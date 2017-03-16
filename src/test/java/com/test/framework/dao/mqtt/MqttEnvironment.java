package com.test.framework.dao.mqtt;

public enum MqttEnvironment {

    FUNCTION("FUNCTION"),   //功能测试
    AUTOTEST("AUTOTEST");  //自动化测试
    private String code;

    MqttEnvironment(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
