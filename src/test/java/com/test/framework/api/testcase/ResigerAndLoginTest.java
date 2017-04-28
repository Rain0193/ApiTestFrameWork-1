package com.test.framework.api.testcase;

import com.test.framework.api.accessor.RegisterAndLoginAccessor;
import com.test.framework.api.requestVO.RegisterAndLoginRequest;
import com.test.framework.common.utils.DbMonitor;
import com.test.framework.dao.mysql.dao.UmAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author hong.lin
 * @description
 * @date 2017/2/17.
 */
@ContextConfiguration("classpath*:spring-common.xml")
public class ResigerAndLoginTest extends AbstractTestNGSpringContextTests{
    private RegisterAndLoginAccessor resigerAndLoginAccessor;
    private RegisterAndLoginRequest registerAndLoginRequest;
    private DbMonitor dbMonitor = null;
    @Autowired
    private UmAccountMapper umAccountMapper;

    @BeforeClass
    public void setUp() {
//        dbMonitor = new DbMonitor();
//        registerAndLoginRequest = new RegisterAndLoginRequest();
//        //TODO 初始化请求对象registerAndLoginRequest,set各种数据
//
//        dbMonitor.startMonitor(); //开启数据库监控
//        resigerAndLoginAccessor = new RegisterAndLoginAccessor();
    }




    @DataProvider
    public Object[][] correctParameters() {
        return new Object[][]{
                {registerAndLoginRequest},
        };
    }

    @Test
    public void TkMybatisTest(){
        System.out.println(umAccountMapper.selectAll().size());
    }

//    @Test(description = "用户注册登录成功", dataProvider = "correctParameters",groups = "smoke")
//    public void registerAndLoginSuccess(RegisterAndLoginRequest request) {
//        resigerAndLoginAccessor.resigerAndLogin(request);
//    }


//    @AfterClass
//    public void tearDown(){
//        dbMonitor.endMonitor();//还原数据库
//    }
}
