package com.test.framework.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;


/**
 * @author hong.lin
 * @description
 * @date 2017/5/9.
 */
public class RandomFactory {
    public static enum StringType{
        Alphanumeri,Numeric,Alphabetic
    }

    /**
     * 创建随机字符串
     * @param prefix
     * @param suffix
     * @param length
     * @param stringType
     * @return
     */
    public static String createRandomString(String prefix,String suffix,int length,StringType stringType){
        if(prefix.length()>0){
            length = length - prefix.length();
        }
        if(suffix.length()>0){
            length = length - suffix.length();
        }
        switch (stringType){
            case Alphanumeri:     //字母和数字混合
                return prefix+ RandomStringUtils.randomAlphanumeric(length)+suffix;
            case Numeric:         //纯数字
                return prefix+ RandomStringUtils.randomNumeric(length)+suffix;
            case Alphabetic:      //纯字母
                return prefix+ RandomStringUtils.randomAlphabetic(length)+suffix;
            default:
                return null;
        }
    }


    /**
     * 从枚举中随机取值
     * @param ec
     * @param <T>
     * @return
     */
    public static <T> T randomEnum(Class<T> ec) {
        T[] values = ec.getEnumConstants();
        Random random = new Random();
        return values[random.nextInt(values.length)];
    }
}
