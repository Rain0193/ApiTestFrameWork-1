package com.test.framework.common.utils.reporter;

import com.test.framework.common.utils.annotation.RestInterface;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hong.lin
 * @description
 * @date 2017/4/20.
 */
public class ReflectionUtil {
    private final static String casePath = "com.test.framework.api.testcase";

    public static Map<String, List<TestSuite>> getTestCaseInfo() {
        Map<String,List<TestSuite>> map = new HashMap<String,List<TestSuite>>();
        File f = new File(ReflectionUtil.class.getClassLoader().getResource(casePath.replace(".", "/")).getPath());
        for (String classFile : f.list()) {
            if (classFile.endsWith(".class") == true) {
                List<TestSuite> testSuiteList = new ArrayList<TestSuite>();
                String className = casePath + "." + classFile.substring(0, classFile.indexOf(".class"));
                try {
                    Class object = ReflectionUtil.class.getClassLoader().loadClass(className);
                    if (object.isAnnotationPresent(RestInterface.class)) {
                        TestSuite testSuite = new TestSuite();
                        Annotation interfaceAnnotation = object.getAnnotation(RestInterface.class);
                        String url = getAnnotationFieldValue(interfaceAnnotation, "url");
                        String group = getAnnotationFieldValue(interfaceAnnotation, "group");
                        boolean isCompleted =  Boolean.valueOf(getAnnotationFieldValue(interfaceAnnotation, "isCompleted"));
                        List<TestCase> caseList = new ArrayList<TestCase>();
                        for (Method method : object.getDeclaredMethods()) {
                            if (method.isAnnotationPresent(org.testng.annotations.Test.class)) {
                                TestCase testCase = new TestCase();
                                Annotation annotation = method.getAnnotation(org.testng.annotations.Test.class);
                                String testDescription = getAnnotationFieldValue(annotation, "description");
                                testCase.setClassName(object.getSimpleName());
                                testCase.setCaseName(method.getName());
                                testCase.setDescription(testDescription);
                                caseList.add(testCase);
                            }
                        }
                        testSuite.setTestCaseList(caseList);
                        testSuite.setUrlPath(url);
                        testSuite.setCompleted(isCompleted);
                        testSuiteList.add(testSuite);
                        if(map.containsKey(group)){
                            List<TestSuite> list = map.get(group);
                            list.add(testSuite);
                            map.put(group,list);
                        }else{
                            map.put(group,testSuiteList);
                        }
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Load " + className + " failed!");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


    private static String getAnnotationFieldValue(Annotation annotation, String field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = annotation.getClass()
                .getDeclaredMethod(field, null);
        return method.invoke(annotation, null).toString();
    }
}
