package com.test.framework.common.utils;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.test.framework.common.constansts.UnIncludeTables;
import com.test.framework.common.context.SpringContextHolder;
import org.assertj.db.type.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hong.lin
 * @description
 * @date 2017/2/21.
 */
public class DbMonitor {
    private Changes changes = null;
    private String dataSourceBeanId = "carrental_DataSource";
    private String jdbcTemplateBeanId = "carrental_jdbcTemplate";

    public DbMonitor(){

    }

    public DbMonitor(String dataSourceBeanId){
        this.dataSourceBeanId = dataSourceBeanId;
    }

    /**
     * 开启监控
     */
    public void startMonitor(){
        AtomikosDataSourceBean dataSource = SpringContextHolder.getBean(dataSourceBeanId);
        String url = dataSource.getXaProperties().getProperty("url");
        String user = dataSource.getXaProperties().getProperty("user");
        String password = dataSource.getXaProperties().getProperty("password");
        Source source = new Source(url,user,password);
        changes = new Changes(dataSource);
        try {
            changes.setTables(setTables(source, UnIncludeTables.getUnIncludeTables()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        changes.setStartPointNow();
    }

    /**
     * 设置需要监控的Table
     * @param source
     * @return
     * @throws Exception
     */
    public Table[] setTables(Source source, List<String> unIncluedTables){
        List<String> db_list = null;
        try {
            db_list = DbUtil.getTableList(source);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(db_list.size()>0 && unIncluedTables.size()>0){
            db_list.removeAll(unIncluedTables);
        }
        List<Table> tables = new ArrayList<Table>();
        for(String name : db_list){
            tables.add(new Table(source,name));
        }
        Table[] arrays = new Table[tables.size()];
        tables.toArray(arrays);
        return arrays;
    }


    /**
     * 依据Changes组装还原所需的SQL
     * @return
     */
    public void endMonitor(){
        changes.setEndPointNow();
        List<String> pks_list = new ArrayList<String>(); //包含外键的change
        List<String> other_list = new ArrayList<String>(); //不包含外键的change
        List<Change> changeList = changes.getChangesList();
        if(changeList.size()==0){
            return;
        }
        for(Change change:changeList){
            ChangeType type = change.getChangeType();
            String tableName = change.getDataName();
            if(ChangeType.CREATION.equals(type)){
                String id = change.getRowAtEndPoint().getValuesList().get(0).getColumnName();
                Object value = change.getRowAtEndPoint().getValuesList().get(0).getValue();
                String sql = "delete from "+tableName+" where "+id+" = "+value+"";  //通过Id删除数据
                if(change.getPksNameList().size()>0){
                    pks_list.add(sql);
                }else{
                    other_list.add(sql);
                }
            }else if(ChangeType.DELETION.equals(type)){
                String sql = "insert into "+tableName+" (";
                String values = " values(";
                List<Value> valuesList = change.getRowAtStartPoint().getValuesList();
                for(Value value : valuesList){
                    Object columenValue = value.getValue();
                    String columnName = value.getColumnName();
                    if(null != columenValue){       //如果值为空,则该字段不插入,避免异常
                        sql = sql + columnName+",";
                        values = values+"'"+columenValue+"',";
                    }
                }
                sql = sql.substring(0,sql.length()-1)+")" +values.substring(0,values.length()-1)+")";
                if(change.getPksNameList().size()>0){
                    pks_list.add(sql);
                }else{
                    other_list.add(sql);
                }
            }else if(ChangeType.MODIFICATION.equals(type)){
                String sql = "update "+tableName+" SET ";
                List<Value> valuesList = change.getRowAtStartPoint().getValuesList();
                for(Value value : valuesList){
                    Object columenValue = value.getValue();
                    String columnName = value.getColumnName();
                    if(null != columenValue){
                        sql = sql + columnName +"='"+columenValue+"' ,";
                    }
                }
                sql = sql.substring(0, sql.length()-1);
                sql = sql + " where "+valuesList.get(0).getColumnName()+" = "+valuesList.get(0).getValue();
                if(change.getPksNameList().size()>0){
                    pks_list.add(sql);
                }else{
                    other_list.add(sql);
                }
            }
        }
        JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
        bathUpdate(jdbcTemplate,other_list);
        recursionBathUpdate(jdbcTemplate,pks_list);
    }


    /**
     * 数据还原
     * @param sqls
     */
    private void bathUpdate(JdbcTemplate jdbcTemplate,List<String> sqls){
        if(sqls.size()==0){
            return;
        }
        String[] array = new String[sqls.size()];
        sqls.toArray(array);
        jdbcTemplate.batchUpdate(array);
    }

    /**
     * 包含外键,递归删除
     * @param jdbcTemplate
     * @param sqls
     */
    private void recursionBathUpdate(JdbcTemplate jdbcTemplate,List<String> sqls){
        if(sqls.size()==0){
            return;
        }
        Iterator<String> iterator = sqls.iterator();
        while (iterator.hasNext()){
            String sql = iterator.next();
            try {
                jdbcTemplate.update(sql);
                iterator.remove();
            }catch (DataIntegrityViolationException e){
                System.out.println(e);
            }
        }
        if(sqls.size()>0){
            recursionBathUpdate(jdbcTemplate,sqls);
        }
    }



    /**
     * 容器中取出TempLate对象
     * @return
     */
    private JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = SpringContextHolder.getBean(jdbcTemplateBeanId);
        return jdbcTemplate;
    }

}
