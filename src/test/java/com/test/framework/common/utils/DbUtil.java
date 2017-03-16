package com.test.framework.common.utils;


import org.assertj.db.type.Source;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hong.lin
 * @description
 * @date 2017/2/28.
 */
public class DbUtil {
	/**
	 * 获取数据库中所有的table
	 * @param source
	 * @return
     */
	public static List<String> getTableList(Source source) throws SQLException {
		  List<String> table_list = new ArrayList<String>();
		  try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.out.println(e.getLocalizedMessage());
	            e.printStackTrace();
	        }
			Connection con = DriverManager.getConnection(source.getUrl(), source.getUser(), source.getPassword());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("show tables");
			while(rs.next()) {
				table_list.add(rs.getString(1));
			}
			stmt.close();
			con.close();
	        return table_list;
	}
}
