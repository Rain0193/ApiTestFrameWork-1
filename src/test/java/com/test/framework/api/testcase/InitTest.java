package com.test.framework.api.testcase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;

/**
 * 初始化测试数据
 */
@ContextConfiguration("classpath*:spring-common.xml")
public class InitTest extends AbstractTestNGSpringContextTests {
    public void setDataSource(javax.sql.DataSource dataSource) {}



    @Override
    @BeforeSuite
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
        //TODO 插入测试基础数据
    }



    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-common.xml");
        InitTest initTest = new InitTest();
        context.getAutowireCapableBeanFactory().autowireBean(initTest);
        //TODO 插入测试基础数据
    }

}
