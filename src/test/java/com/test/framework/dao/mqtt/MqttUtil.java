package com.test.framework.dao.mqtt;

import com.test.framework.dao.mqtt.entity.AuthObject;
import com.beecloud.platform.protocol.core.constants.ApplicationID;
import com.beecloud.platform.protocol.core.element.Authentication;
import com.beecloud.platform.protocol.core.element.TimeStamp;
import com.beecloud.platform.protocol.core.element.VehicleDescriptor;
import com.beecloud.platform.protocol.core.header.ApplicationHeader;
import com.beecloud.platform.protocol.core.message.AbstractMessage;
import com.beecloud.platform.protocol.core.message.AuthReqMessage;
import com.beecloud.platform.protocol.util.binary.ProtocolUtil;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by dell on 2016/11/10.
 */
public class MqttUtil {

    private static String connect_url;
    private static String disconnect_url;
    private static String sendmessage_url;
    private static String getmessage_url;
    private static String subscribe_url;
    private static String unSubscribe_url;
    private static String cleanCache_url;
    private static String auto_insert_funcion = "http://10.28.4.25:8888/beecloud/tbox/insert";
    private static String type = MqttEnvironment.FUNCTION.getCode();

    public static void connect(String threadName){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("threadName",threadName);
        params.put("type",type);
        RequestSpecification request = given();
        request.queryParameters(params);
        request.post(connect_url);
    }

    /**
     * 生成认证消息
     * @return
     */
    private static AuthReqMessage getAuthReqMessage(AuthObject authObject){
        AuthReqMessage authReqMessage = new AuthReqMessage();
        ApplicationHeader applicationHeader = new ApplicationHeader();
        applicationHeader.setStepId(0);
        applicationHeader.setApplicationID(ApplicationID.ID_AUTH);
        applicationHeader.setSequenceId(0);
        applicationHeader.setProtocolVersion(0);
        Authentication authentication = new Authentication();
        authentication.setPid("BEECLOUD");

        String iccid = authObject.getIccid();
        String imei = authObject.getImei();
        String tboxSerial = authObject.getTboxSerial();
        VehicleDescriptor vehicleDescriptor = new VehicleDescriptor();
        vehicleDescriptor.setTboxSerial(tboxSerial);
        vehicleDescriptor.setIccid(iccid);
        vehicleDescriptor.setImei(imei);
        vehicleDescriptor.setVin(authObject.getVin());
        TimeStamp timeStamp = new TimeStamp(new Date());

        authReqMessage.setTimeStamp(timeStamp);
        authReqMessage.setApplicationHeader(applicationHeader);
        authReqMessage.setAuthentication(authentication);
        authReqMessage.setVehicleDescriptor(vehicleDescriptor);
        return authReqMessage;
    }


    /**
     * Tbox认证
     * @param authObject
     */
    public static void auth(String threadName,AuthObject authObject){
        AuthReqMessage authReqMessage = getAuthReqMessage(authObject);
    	sendMessage(threadName,authReqMessage);
    }

    public static void autoInsert4Function(String name,String data){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name",name);
        params.put("data",data);
        RequestSpecification request = given();
        request.queryParameters(params);
        request.post(auto_insert_funcion);
    }

    /**
     * 订阅
     * @param topic
     */
    public static void subscribe(String threadName,String topic){
    	Map<String,Object> params = new HashMap<String,Object>();
        params.put("threadName",threadName);
        params.put("topic",topic);
        params.put("type",type);
    	RequestSpecification request = given();
    	request.queryParameters(params);
    	request.post(subscribe_url);
    }


    /**
     * 退订
     * @param threadName
     * @param topic
     */
    public static void unSubscribe(String threadName,String topic){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("threadName",threadName);
        params.put("topic",topic);
        params.put("type",type);
        RequestSpecification request = given();
        request.queryParameters(params);
        request.post(unSubscribe_url);
    }


    /**
     * 清除缓存
     * @param threadName
     */
    public static void cleanCache(String threadName){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("threadName",threadName);
        params.put("type",type);
        RequestSpecification request = given();
        request.queryParameters(params);
        request.post(cleanCache_url);
    }






    public static void sendMessage(String threadName,AbstractMessage abstractMessage){
        byte[] data = abstractMessage.encode();
        String message = ProtocolUtil.bytesToFormatBitString(data);
    	RequestSpecification request = given();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("threadName",threadName);
        params.put("message",message);
        params.put("type",type);
        request.queryParameters(params);
        request.post(sendmessage_url);
    }


    public static String getTboxMessage(String threadName,String key,int timeOut){
    	key = "mqtt/vehicle/"+key;
    	RequestSpecification request = given();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("threadName",threadName);
        params.put("key",key);
        params.put("timeOut", timeOut);
        params.put("type",type);
        request.queryParams(params);
        Response response = request.post(getmessage_url);
        return response.getBody().asString();
    }
    
    public static String getAppMessage(String threadName,String key,int timeOut){
    	RequestSpecification request = given();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("threadName",threadName);
        params.put("key",key);
        params.put("timeOut", timeOut);
        params.put("type",type);
        request.queryParams(params);
        Response response = request.post(getmessage_url);
        return response.getBody().asString();
    }


    
    
    public static void disconnect(String threadName){
    	RequestSpecification request = given();
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("type",type);
    	params.put("threadName",threadName);
    	request.queryParams(params);
    	request.get(disconnect_url);
    }

    public static String getUnSubscribe_url() {
        return unSubscribe_url;
    }

    public static void setUnSubscribe_url(String unSubscribe_url) {
        MqttUtil.unSubscribe_url = unSubscribe_url;
    }

    public static String getCleanCache_url() {
        return cleanCache_url;
    }

    public static void setCleanCache_url(String cleanCache_url) {
        MqttUtil.cleanCache_url = cleanCache_url;
    }

    public static String getConnect_url() {
        return connect_url;
    }

    public static void setConnect_url(String connect_url) {
        MqttUtil.connect_url = connect_url;
    }

    public static String getDisconnect_url() {
        return disconnect_url;
    }

    public static void setDisconnect_url(String disconnect_url) {
        MqttUtil.disconnect_url = disconnect_url;
    }

    public static String getSendmessage_url() {
        return sendmessage_url;
    }

    public static void setSendmessage_url(String sendmessage_url) {
        MqttUtil.sendmessage_url = sendmessage_url;
    }

    public static String getGetmessage_url() {
        return getmessage_url;
    }

    public static void setGetmessage_url(String getmessage_url) {
        MqttUtil.getmessage_url = getmessage_url;
    }

    public static String getSubscribe_url() {
        return subscribe_url;
    }

    public static void setSubscribe_url(String subscribe_url) {
        MqttUtil.subscribe_url = subscribe_url;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        MqttUtil.type = type;
    }

    public static void  initConfig() {
        Properties properties = new Properties();
        try {
            String dataFile = MqttUtil.class.getClassLoader().getResource("mqtt-mock-server.properties").getFile();
            properties.load(new FileInputStream(dataFile));
        } catch (IOException err) {
            Reporter.log("Read mqtt-mock-server.properties failed, use default value", true);
        }
        MqttUtil.setConnect_url(properties.getProperty("connect_url", connect_url));
        MqttUtil.setDisconnect_url(properties.getProperty("disconnect_url", disconnect_url));
        MqttUtil.setSubscribe_url(properties.getProperty("subscribe_url", subscribe_url));
        MqttUtil.setGetmessage_url(properties.getProperty("getmessage_url", getmessage_url));
        MqttUtil.setSendmessage_url(properties.getProperty("sendmessage_url", sendmessage_url));
        MqttUtil.setUnSubscribe_url(properties.getProperty("unSubscribe_url", unSubscribe_url));
        MqttUtil.setCleanCache_url(properties.getProperty("cleanCache_url", cleanCache_url));
        MqttUtil.setType(properties.getProperty("mqtt_env", type));
        Reporter.log("connect_url: " + MqttUtil.getConnect_url(), true);
        Reporter.log("disconnect_url: " + MqttUtil.getDisconnect_url(), true);
        Reporter.log("subscriber_url: " + MqttUtil.getSubscribe_url(), true);
        Reporter.log("getmessage_url: " + MqttUtil.getGetmessage_url(), true);
        Reporter.log("sendmessage_url: " + MqttUtil.getSendmessage_url(), true);
        Reporter.log("unSubscribe_url: " + MqttUtil.getUnSubscribe_url(), true);
        Reporter.log("cleanCache_url: " + MqttUtil.getCleanCache_url(), true);
        Reporter.log("mqtt_type: " + MqttUtil.getType(), true);
    }


}
