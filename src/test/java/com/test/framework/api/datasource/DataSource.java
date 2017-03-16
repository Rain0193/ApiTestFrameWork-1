/**
 * 
 */
package com.test.framework.api.datasource;


import com.test.framework.common.utils.DataUtil;

/**
 * @description 测试所需基础数据
 * @author hong.lin@beecloud.com
 * @date 2016年8月16日 上午9:42:08
 * @version v1.0
 */
public class DataSource {
	private static ApiSet apiSet;
	private static DataSet dataSet;
	private static TestBed testBed;
	static{
		apiSet = DataUtil.getApiSet();
        dataSet = DataUtil.getDataSet();
        testBed = DataUtil.getTestBed();
	}
	public static ApiSet getApiSet() {
		return apiSet;
	}
	
	public static DataSet getDataSet() {
		return dataSet;
	}
	
	public static TestBed getTestBed(){
		return testBed;
	}

}
