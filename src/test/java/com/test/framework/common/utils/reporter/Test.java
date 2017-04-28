package com.test.framework.common.utils.reporter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author hong.lin
 * @description
 * @date 2017/4/20.
 */
public class Test {
    public static void main(String ...args){
        Map<String,List<TestSuite>> data =ReflectionUtil.getTestCaseInfo();
        Generator generator = new Generator(data);
        try {
            generator.productReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
