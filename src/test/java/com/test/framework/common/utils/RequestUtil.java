/**
 *
 */
package com.test.framework.common.utils;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.io.File;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author hong.lin@beecloud.com
 * @version v1.0
 * @description //TODO
 * @date 2016年8月24日 上午10:17:59
 */
public class RequestUtil {
    private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);


    /**
     * 请求参数中包含文件时,传入File对象
     *
     * @param api
     * @param pathParms
     * @param queryParams
     * @param header
     * @param expectedHttpStatusCode
     * @return
     */
    public static Response Get(String api, Map<String, Object> pathParms, Map<String, Object> queryParams,
                               Map<String, String> header, int expectedHttpStatusCode) {
        RequestSpecification request = given();
        Response response = null;
        Reporter.log(String.format("trying to get %s, parmas %s, header %s,pathParms %s", api, queryParams, header,
                pathParms));
        logger.debug("trying to call {}, params {} headers {} pathParms{}", api, queryParams, header, pathParms);
        if (null != queryParams) {
            _setQueryParams(request, queryParams);
        }
        if (null != header) {
            request.headers(header);
        }
        if (null != pathParms) {
            _setPathParams(request, pathParms);
        }
        response = request.get(api);
        Reporter.log("cost time:" + response.getTime() + " ms", true);
        logger.debug("cost time {}", response.getTime() + " ms");
        Reporter.log("response body: " + response.asString(), true);
        if (0 < expectedHttpStatusCode) {
            assertThat(response.getStatusCode(), equalTo(expectedHttpStatusCode));
        }
        return response;
    }


    public static Response PostForm(String api, Map<String, Object> pathParms, Map<String, Object> queryParams,
                                    Map<String, String> header, int expectedHttpStatusCode) {
        RequestSpecification request = given();
        Response response = null;
        Reporter.log(String.format("trying to get %s, parmas %s, header %s,pathParms %s", api, queryParams, header,
                pathParms));
        logger.debug("trying to call {}, params {} headers {} pathParms{}", api, queryParams, header, pathParms);
        if (null != queryParams) {
            _setQueryParams(request, queryParams);
        }
        if (null != header) {
            request.headers(header);
        }
        if (null != pathParms) {
            _setPathParams(request, pathParms);
        }
        response = request.post(api);
        Reporter.log("cost time:" + response.getTime() + " ms", true);
        logger.debug("cost time {}", response.getTime() + " ms");
        Reporter.log("response body: " + response.asString(), true);
        if (0 < expectedHttpStatusCode) {
            assertThat(response.getStatusCode(), equalTo(expectedHttpStatusCode));
        }
        return response;
    }


    /**
     * Json参数请求
     *
     * @param api
     * @param json
     * @param headers
     * @param expectedHttpStatusCode
     * @return
     */
    public static Response PostJson(String api, Map<String, Object> pathParms, String json, Map<String, String> headers,
                                    int expectedHttpStatusCode) {
        RequestSpecification request = given();
        Response response = null;
        request = request.contentType(ContentType.JSON);
        if (null != headers) {
            request.headers(headers);
        }
        if (null != pathParms) {
            _setPathParams(request, pathParms);
        }
        if (null != json) {
            request = request.body(json.toString());
        }
        Reporter.log(String.format("trying to post %s,with %s, headers %s ", api, json.toString(), headers), true);
        logger.debug("trying to call {} with {}, headers {} ", api, json.toString(), headers);
        response = request.post(api);
        Reporter.log("cost time:" + response.getTime() + " ms");
        logger.debug("cost time {}", response.getTime() + " ms");
        Reporter.log("Response body: " + response.getBody().asString(), true);
        if (0 < expectedHttpStatusCode) {
            assertThat(response.getStatusCode(), equalTo(expectedHttpStatusCode));
        }
        return response;
    }


    private static void _setQueryParams(RequestSpecification requestSpecification, Map<String, Object> queryParams) {
        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            if (null == entry.getValue()) {
                continue;
            }
            if ((File.class.getName()).equals(entry.getValue().getClass().getName())) {
                requestSpecification.contentType("multipart/form-data");
                requestSpecification.multiPart(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof Object[]) {
                Object[] arr = (Object[])(entry.getValue());
//                String[] arr = (String[]) (entry.getValue());
                for (int i = 0; i < arr.length; i++) {
                    requestSpecification.queryParam(entry.getKey(), arr[i].toString());
                }
            } else {
                requestSpecification.queryParam(entry.getKey(), entry.getValue());
            }
        }
    }

    private static void _setPathParams(RequestSpecification requestSpecification, Map<String, Object> pathParams) {
        for (Map.Entry<String, Object> entry : pathParams.entrySet()) {
            requestSpecification.pathParam(entry.getKey(), entry.getValue());
        }
    }

    public static Response PostJson(String api, Map<String, Object> pathParms, Map<String, Object> queryParams,
                                    Map<String, String> header, int expectedHttpStatusCode) {
        RequestSpecification request = given();
        Response response = null;
        Reporter.log(String.format("trying to get %s, parmas %s, header %s,pathParms %s", api, queryParams, header,
                pathParms));
        logger.debug("trying to call {}, params {} headers {} pathParms{}", api, queryParams, header, pathParms);
        if (null != queryParams) {
            _setQueryParams(request, queryParams);
        }
        if (null != header) {
            request.headers(header);
        }
        if (null != pathParms) {
            _setPathParams(request, pathParms);
        }
        response = request.post(api);
        Reporter.log("cost time:" + response.getTime() + " ms", true);
        logger.debug("cost time {}", response.getTime() + " ms");
        Reporter.log("response body: " + response.asString(), true);
        if (0 < expectedHttpStatusCode) {
            assertThat(response.getStatusCode(), equalTo(expectedHttpStatusCode));
        }
        return response;
    }

    public static Response delete(String api, Map<String, Object> pathParms, Map<String, Object> queryParams,
                                  Map<String, String> header, String json, int expectedHttpStatusCode) {
        RequestSpecification request = given();
        Response response = null;
        Reporter.log(
                String.format("trying to delete %s with %s, parmas %s, header %s,pathParms %s", api, json.toString(),
                        queryParams, header,
                        pathParms), true);
        logger.debug("trying to call {}, params {} headers {} pathParms{}", api, queryParams, header, pathParms);
        if (null != queryParams) {
            _setQueryParams(request, queryParams);
        }
        if (null != header) {
            request.headers(header);
        }
        if (null != pathParms) {
            _setPathParams(request, pathParms);
        }
        if (null != json) {
            request = request.body(json.toString());
        }
        response = request.delete(api);
        Reporter.log("cost time:" + response.getTime() + " ms", true);
        logger.debug("cost time {}", response.getTime() + " ms");
        Reporter.log("response body: " + response.asString(), true);
        if (0 < expectedHttpStatusCode) {
            assertThat(response.getStatusCode(), equalTo(expectedHttpStatusCode));
        }
        return response;
    }

}
