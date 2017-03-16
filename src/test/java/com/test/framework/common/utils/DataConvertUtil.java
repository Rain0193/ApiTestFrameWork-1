/**
 * 
 */
package com.test.framework.common.utils;

import com.google.gson.Gson;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description //TODO
 * @author hong.lin@beecloud.com
 * @date 2016年8月16日 下午3:13:36
 * @version v1.0
 */
public class DataConvertUtil {
	
	/**
	 * 转换Bean对象为Map对象
	 * @param obj
	 * @return Map
	 */
	public static Map<String, Object> transBean2Map(Object obj) {
        if(obj == null){
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
                if (!key.equals("class")) {  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    map.put(key, value);  
                }  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
        return map;
    }
	
	/**
	 * 转换Bean对象为Json字符串
	 * @param obj
	 * @return
	 */
	public static String transBean2Json(Object obj) {
		 Gson gson = new Gson();
	     return gson.toJson(obj);
    }

	
}
