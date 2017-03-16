/**
 *
 */
package com.test.framework.api.accessor;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import com.test.framework.api.requestVO.BaseRequest;
import com.test.framework.common.utils.DataConvertUtil;
import com.test.framework.common.utils.RequestUtil;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hong.lin@beecloud.com
 * @version v1.0
 * @description //TODO
 * @date 2016年8月24日 上午10:13:26
 */
public abstract class BaseHTTPAccessor {
    public abstract String getUrl();

    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Map<String, String> createHeader() {
        Map<String, String> header = new HashMap<String, String>();
        if (msgId != null) {
            header.put("msgId", msgId);
        }
        return header;
    }

    public <T> T get(Class<T> resResponseType, int expectedHttpStatusCode) {
        return get(null, resResponseType, expectedHttpStatusCode);
    }

    public <T> T get(Map<String, Object> pathParams, Class<T> resResponseType, int expectedHttpStatusCode) {
        return get(pathParams, null, resResponseType, expectedHttpStatusCode);
    }

    public <T> T get(Map<String, Object> pathParams, Map<String, Object> queryParams, Class<T> resResponseType,
                     int expectedHttpStatusCode) {
        return get(pathParams, queryParams, createHeader(), resResponseType, expectedHttpStatusCode);
    }

    public <T> T get(Map<String, Object> pathParams, Map<String, Object> queryParams, Map<String, String> header,
                     Class<T> resResponseType,
                     int expectedHttpStatusCode) {
        Response response = RequestUtil.Get(getUrl(), pathParams, queryParams, header, expectedHttpStatusCode);
        if (resResponseType.getName().equals(Response.class.getName())) {
            return (T) response;
        }
        String body = response.getBody().asString();
        Reporter.log("getBody:"+body,true);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        T t = gson.fromJson(body, resResponseType);
        return t;
    }


    public <T> T postForm(Map<String, Object> queryParams, Class<T> resResponseType, int expectedHttpStatusCode) {
        return postForm(null, queryParams, resResponseType, expectedHttpStatusCode);
    }

    public <T> T postForm(Map<String, Object> pathParms, Map<String, Object> queryParams, Class<T> resResponseType,
                          int expectedHttpStatusCode) {
        return postForm(pathParms, queryParams, createHeader(), resResponseType, expectedHttpStatusCode);
    }

    public <T> T postForm(Map<String, Object> pathParms, Map<String, Object> queryParams, Map<String, String> header,
                          Class<T> resResponseType,
                          int expectedHttpStatusCode) {
        Response response = RequestUtil
                .PostForm(getUrl(), pathParms, queryParams, header, expectedHttpStatusCode);
        if (resResponseType.getSimpleName().equals(Response.class.getSimpleName())) {
            return (T) response;
        }
        String body = response.getBody().asString();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        T t = gson.fromJson(body, resResponseType);
        return t;
    }


    public <T> T postJson(BaseRequest request, Class<T> resResponseType, int expectedHttpStatusCode) {
        return postJson(null, request, resResponseType, expectedHttpStatusCode);
    }

    public <T> T postJson(Map<String, Object> pathParms, BaseRequest request, Class<T> resResponseType,
                          int expectedHttpStatusCode) {
        Response response = RequestUtil
                .PostJson(getUrl(), pathParms, DataConvertUtil.transBean2Json(request), createHeader(),
                        expectedHttpStatusCode);
        if (resResponseType.getSimpleName().equals(Response.class.getSimpleName())) {
            return (T) response;
        }
        String body = response.getBody().asString();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        T t = gson.fromJson(body, resResponseType);
        return t;
    }

    public <T> T postJson(Map<String, Object> pathParms, Map<String, Object> queryParams, Class<T> resResponseType,
                          int expectedHttpStatusCode) {
        Response response = RequestUtil
                .PostForm(getUrl(), pathParms, queryParams, createHeader(), expectedHttpStatusCode);
        if (resResponseType.getSimpleName().equals(Response.class.getSimpleName())) {
            return (T) response;
        }
        String body = response.getBody().asString();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        T t = gson.fromJson(body, resResponseType);
        return t;
    }

    public <T> T delete(Map<String, Object> pathParms, Map<String, Object> queryParams, BaseRequest request,
                        Class<T> resResponseType, int expectedHttpStatusCode) {
        Response response = RequestUtil
                .delete(getUrl(), pathParms, queryParams, createHeader(), DataConvertUtil.transBean2Json(request),
                        expectedHttpStatusCode);
        if (resResponseType.getSimpleName().equals(Response.class.getSimpleName())) {
            return (T) response;
        }
        String body = response.getBody().asString();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        T t = gson.fromJson(body, resResponseType);
        return t;
    }

}
