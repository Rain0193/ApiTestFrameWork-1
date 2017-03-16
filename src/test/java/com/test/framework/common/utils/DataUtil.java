/**
 * 
 */
package com.test.framework.common.utils;


import com.esotericsoftware.yamlbeans.YamlReader;
import com.test.framework.api.datasource.ApiSet;
import com.test.framework.api.datasource.DataSet;
import com.test.framework.api.datasource.TestBed;

import java.io.InputStreamReader;

/**
 * @description //TODO
 * @author hong.lin@beecloud.com
 * @date 2016年8月16日 上午9:19:59
 * @version v1.0
 */
public class DataUtil {
	private static final String APISetYaml = "datasource/ApiSet.yml";
	private static final String DATASetYaml = "datasource/DataSet.yml";
	private static final String TestBedYaml = "datasource/TestBed.yml";


	/**
	 * 获取Api路径
	 * @return
	 */
	public static ApiSet getApiSet(){
		ApiSet apiSet = null;
        try {
            	YamlReader reader = new YamlReader(new InputStreamReader(
						DataUtil.class.getClassLoader().getResourceAsStream(APISetYaml)
				,"UTF-8"));
            	apiSet = reader.read(ApiSet.class);
        	} catch (Exception e) {
			e.printStackTrace();
        	}
        return apiSet;
    }

	
	/**
	 * 获取Api参数
	 * @return
	 */
	public static DataSet getDataSet(){
		DataSet dataSet = null;
        try {
            	YamlReader reader = new YamlReader(new InputStreamReader(
            			DataUtil.class.getClassLoader().getResourceAsStream(DATASetYaml), "UTF-8"));
            	dataSet = reader.read(DataSet.class);
        	} catch (Exception e) {
				e.printStackTrace();
        	}
        return dataSet;
    }
	
	
	/**
	 * 获取请求基本信息
	 * @return
	 */
	public static TestBed getTestBed(){
		TestBed testBed = null;
        try {
            	YamlReader reader = new YamlReader(new InputStreamReader(
						DataUtil.class.getClassLoader().getResourceAsStream(TestBedYaml),"UTF-8"));
            	testBed = reader.read(TestBed.class);
        	} catch (Exception e) {
			e.printStackTrace();
        	}
        return testBed;
    }
}
