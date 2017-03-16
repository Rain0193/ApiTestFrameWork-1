package com.test.framework.api.accessor;


import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.test.framework.api.datasource.DataSource;
import com.test.framework.api.requestVO.RegisterAndLoginRequest;
import com.test.framework.api.responseVO.RegisterAndLoginResponse;
import com.test.framework.common.utils.DataConvertUtil;
import com.test.framework.common.utils.RequestUtil;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hong.lin
 * @description
 * @date 2017/2/20.
 */
public abstract class BaseLoginHTTPAccessor extends BaseHTTPAccessor {
    public abstract String getUrl();

    public final String loginUrl = DataSource.getTestBed().getApiBaseUrl()+DataSource.getApiSet().getResigerAndLoginUrlPath();
    private RegisterAndLoginRequest registerAndLoginRequest;
    private Map<String,String> header = null;
    private String msgId;
    private String token;
    public BaseLoginHTTPAccessor(RegisterAndLoginRequest registerAndLoginRequest, String msgId){
        this.registerAndLoginRequest = registerAndLoginRequest;
        this.msgId = msgId;
    }

    public BaseLoginHTTPAccessor() {}

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Map<String, String> createHeader(){
        if(null != header){     //单个Case中token复用
            return header;
        }
        header = new HashMap<String, String>();
        Map<String,String> loginHeader = new HashMap<String,String>();
        loginHeader.put("msgId", msgId);
        Response  response = null;
        try{
            response = RequestUtil.PostJson(loginUrl,null,DataConvertUtil.transBean2Json(registerAndLoginRequest),loginHeader,200);
        }catch(Exception e){
            Reporter.log("登录失败");
        }
        String body = response.getBody().asString();
        Gson gson = new Gson();
        RegisterAndLoginResponse registerAndLoginResponse = gson.fromJson(body, RegisterAndLoginResponse.class);
        token = registerAndLoginResponse.getToken();
        header.put("token",token);
        header.put("msgId",msgId);
        return header;
    }
}
