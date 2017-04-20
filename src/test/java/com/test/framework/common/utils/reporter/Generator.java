package com.test.framework.common.utils.reporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

/**
 * @author hong.lin
 * @description
 * @date 2017/4/20.
 */
public class Generator {
    private static  final String reporterName = "beecloud";
    private Map<String,List<TestSuite>> caseInfo;
    private StringBuilder stringBuilder = new StringBuilder();
    public Generator(Map<String,List<TestSuite>> caseInfo){
        this.caseInfo = caseInfo;
    }


    public void productReport() throws IOException {
        stringBuilder.append(productHeadData());
        int groupId = 0;
        for (Map.Entry<String,List<TestSuite>> m : caseInfo.entrySet()) {
            String groupName = m.getKey();
            List<TestSuite> groupValue = m.getValue();
            stringBuilder.append(productGroupHeadData(groupId,groupName));
            for(int i=0;i<groupValue.size();i++){
                stringBuilder.append(productSuiteData(groupValue.get(i)));
            }
            stringBuilder.append(productGroupEndData());
            groupId ++;
        }
        stringBuilder.append(productEndData());
        writeToFile(reporterName,stringBuilder.toString());
    }


    /**
     * 保存到文件
     * @param fileName
     * @param str
     */
    private void writeToFile(String fileName,String str) throws IOException {
        String path = fileName+".html";
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gb2312");
        outputStreamWriter.write(str);
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }


    /**
     * 构建文件头
     * @return
     */
    private String productHeadData(){
        return "<html>\n" +
                "<head>\n" +
                "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\n" +
                "    <title>BeeCloud</title>\n" +
                "\t<link rel=\"stylesheet\" href=\"http://www.bootcss.com/p/layoutit/css/bootstrap-combined.min.css\">\n" +
                "\t<link href=\"http://www.bootcss.com/p/layoutit/css/layoutit.css\" rel=\"stylesheet\">\n" +
                "\t<script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>\n" +
                "\t<script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
                "\t<h3>\n" +
                "\t\t\t云蜂接口测试用例集\n" +
                "\t</h3>\n" +
                "</head>";
    }


    /**
     * 构建group数据
     * @param groupId
     * @param groupName
     * @return
     */
    private String productGroupHeadData(int groupId,String groupName){
       return "<div class=\"panel-group\" id=\"accordion"+groupId+"\">\n" +
                "\t<div class=\"panel panel-default\">\n" +
                "\t\t<div class=\"panel-heading\">\n" +
                "\t\t\t<h4 class=\"panel-title\">\n" +
                "\t\t\t\t<a data-toggle=\"collapse\" data-parent=\"#accordion"+groupId+"\" \n" +
                "\t\t\t\t   href=\"#collapse"+groupId+"\">\n" +
                "\t\t\t\t\t"+groupName+"\n" +
                "\t\t\t\t</a>\n" +
                "\t\t\t</h4>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"collapse"+groupId+"\" class=\"panel-collapse collapse in\">\n" +
                "\t\t\t<div class=\"panel-body\">\n" +
                "\t\t\t\t<div class=\"container-fluid\">\n" +
                "\t<div class=\"row-fluid\">\n" +
                "\t\t<div class=\"span12\">";
    }


    private String productGroupEndData(){
        return "</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n";
    }




    /**
     * 构建suite数据
     * @param testSuite
     * @return
     */
    private String productSuiteData(TestSuite testSuite){
        StringBuilder stringBuilder = new StringBuilder();
        String status;
        if(testSuite.isCompleted()){
            status = "<p class=\"badge-success\">\n"+"接口路径："+testSuite.getUrlPath()+"\n</p>\n";
        }else{
            status = "<p class=\"badge-warning\">\n"+"接口路径："+testSuite.getUrlPath()+"\n</p>\n";
        }
        stringBuilder.append(status);
        stringBuilder.append(productTableData(testSuite.getTestCaseList()));
        return stringBuilder.toString();
    }

    /**
     * 构建table数据
     * @param testCaseList
     * @return
     */
    private String productTableData(List<TestCase> testCaseList){
        StringBuilder stringBuilder = new StringBuilder();
        String tableHead = "\t\t\t<table class=\"table table-bordered\">\n" +
                "\t\t\t\t<thead>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<th>\n" +
                "\t\t\t\t\t\t\t<span>编号</span>\n" +
                "\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t<th>\n" +
                "\t\t\t\t\t\t\t<span>TestClass</span>\n" +
                "\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t<th>\n" +
                "\t\t\t\t\t\t\t<span>CaseName</span>\n" +
                "\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t\t<th>\n" +
                "\t\t\t\t\t\t\t<span>Description</span>\n" +
                "\t\t\t\t\t\t</th>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</thead>\n" +
                "\t\t\t\t<tbody>";

        stringBuilder.append(tableHead);
        for(int i=1;i<testCaseList.size()+1;i++){
            stringBuilder.append("<tr class=\"info\">\n" +
                    "\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t"+i+"\n" +
                    "\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t"+testCaseList.get(i-1).getClassName()+"\n" +
                    "\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t"+testCaseList.get(i-1).getCaseName()+"\n" +
                    "\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t<pre>"+testCaseList.get(i-1).getDescription()+"</pre>\n" +
                    "\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t</tr>");
        }
        String tableEnd = "</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>";
        stringBuilder.append(tableEnd);
        return  stringBuilder.toString();
    }

    /**
     * html尾
     * @return
     */
    private String productEndData(){
        return "</html>";
    }
}
