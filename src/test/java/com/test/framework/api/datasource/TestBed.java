/**
 *
 */
package com.test.framework.api.datasource;

/**
 * @author hong.lin@beecloud.com
 * @version v1.0
 * @description //TODO
 * @date 2016年8月16日 下午2:01:59
 */
public class TestBed {

    private String apiBaseUrl;
    private String pkiUrl;

    @Override
    public String toString() {
        return "TestBed{" +
                "apiBaseUrl='" + apiBaseUrl + '\'' +
                ", pkiUrl='" + pkiUrl + '\'' +
                '}';
    }

    public String getPkiUrl() {
        return pkiUrl;
    }

    public void setPkiUrl(String pkiUrl) {
        this.pkiUrl = pkiUrl;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

}
