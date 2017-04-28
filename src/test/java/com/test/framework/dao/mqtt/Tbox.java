//package com.test.framework.dao.mqtt;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.test.framework.dao.mqtt.entity.AuthObject;
//import com.beecloud.platform.protocol.core.element.Identity;
//import com.beecloud.platform.protocol.core.message.AbstractMessage;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.jayway.jsonpath.JsonPath;
//import org.testng.Reporter;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.zip.CRC32;
//
//
//public class Tbox {
//    private String sendTopic = "mqtt/server";
//    private String receiveTopic = "mqtt/vehicle/%s";
//    private AuthObject authObject;
//    private Long sequenceId;
//    private Long identityCode = null;
//
//    private final static String COMMON_IDENTITY_CODE = "$.data.identity.identityCode";
//    private final static String SEQUENCE_ID_PATH = "$.data.applicationHeader.sequenceId";
//    private final static String DATA_PATH = "$.data";
//
//
//    public Tbox(AuthObject authObject) {
//        MqttUtil.initConfig();
//        this.authObject = authObject;
//    }
//
//    public Tbox(String vin, String iccid, String imei, String tboxSerial) {
//        MqttUtil.initConfig();
//        authObject = new AuthObject();
//        authObject.setPid("BEECLOUD");
//        authObject.setVin(vin);
//        authObject.setIccid(iccid);
//        authObject.setImei(imei);
//        authObject.setTboxSerial(tboxSerial);
//        auth();
//    }
//
//    /**
//     * 自动认证
//     */
//    public void auth() {
//        String threadName = authObject.getVin();
//        MqttUtil.connect(threadName);
//        MqttUtil.subscribe(authObject.getVin(), String.format(receiveTopic, authObject.getVin()));
//        MqttUtil.auth(threadName,authObject);
//    }
//
//
//    /**
//     * IdentityCode = CRC32(Vehicle Descriptor(见4.4.1)(VIN+ TBox Serial+IMEI+ ICCID)+
//     * Authentication(见4.4.5)(PID))
//     *
//     * @return
//     */
//    public Identity createIdentity() {
//        String tmp = authObject.getVin() + authObject.getTboxSerial() + authObject.getImei() + authObject
//                .getIccid() + authObject.getPid();
//        CRC32 crc32 = new CRC32();
//        crc32.reset();
//        byte[] data = tmp.getBytes();
//        for (byte b : data) {
//            crc32.update(b);
//        }
//        Identity identity = new Identity();
//        String body = getMessage(0, 1, 0, 3);
//        long identityCode = JsonPath.parse(body).read(COMMON_IDENTITY_CODE);
//        identity.setIdentityCode(identityCode);
//        return identity;
//    }
//
//    public Identity getIdentity() {
//        Identity identity = new Identity();
//        if (identityCode != null) {
//            identity.setIdentityCode(identityCode);
//            return identity;
//        }
//        String body = getMessage(0, 1, 0, 3);
//        identityCode = Long.parseLong(JsonPath.parse(body).read(COMMON_IDENTITY_CODE).toString());
//        identity.setIdentityCode(identityCode);
//        return identity;
//    }
//
//    /**
//     * 获取Tbox消息
//     *
//     * @param applicationID
//     * @param stepId
//     * @param sequenceId
//     * @param timeOut(秒)
//     * @return
//     */
//    public String getMessage(int applicationID, int stepId, long sequenceId, int timeOut) {
//        String key = String.valueOf(authObject.getVin().trim()) + String.valueOf(applicationID) + String
//                .valueOf(stepId) + String.valueOf(sequenceId);
//        String message = MqttUtil.getTboxMessage(authObject.getVin(), key, timeOut);
//        Reporter.log("Get message " + key + ": " + message, true);
//        return message;
//    }
//
//    public String getMessage(int applicationID, int stepId, int timeOut) {
//        String key = String.valueOf(authObject.getVin().trim()) + String.valueOf(applicationID) + String
//                .valueOf(stepId) + "*";
//        String message = MqttUtil.getTboxMessage(authObject.getVin(), key, timeOut);
//        Reporter.log("Get message " + key + ": " + message, true);
//        sequenceId = Long.parseLong(JsonPath.parse(message).read(SEQUENCE_ID_PATH).toString());
//        Reporter.log("Get sequence id: " + sequenceId, true);
//        return message;
//    }
//
//    public <T> T getMessage(int applicationID, int stepId, Class<T> resResponseType, int timeOut) {
//        String key = String.valueOf(authObject.getVin().trim()) + String.valueOf(applicationID) + String
//                .valueOf(stepId) + "*";
//        String message = MqttUtil.getTboxMessage(authObject.getVin(), key, timeOut);
//        Reporter.log("Get message " + key + ": " + message, true);
//        sequenceId = Long.parseLong(JsonPath.parse(message).read(SEQUENCE_ID_PATH).toString());
//        Reporter.log("Get sequence id: " + sequenceId, true);
//        JSONObject object = JSON.parseObject(message);
//        String data = null;
//        if (object.keySet().contains("data")) {
//            data = object.getJSONObject("data").toJSONString();
//        }
//        GsonBuilder builder = new GsonBuilder().setDateFormat("MMM dd, yyyy KK:mm:ss a");
//        Gson gson = builder.create();
//        T t = gson.fromJson(data, resResponseType);
//        Reporter.log("Message object: " + t, true);
//        return t;
//    }
//
//    /**
//     * 发送消息
//     *
//     * @param abstractMessage
//     */
//    public void sendMessage(AbstractMessage abstractMessage) {
//        MqttUtil.sendMessage(authObject.getVin(), abstractMessage);
//    }
//
//
//    public void disconnect() {
//        MqttUtil.disconnect(authObject.getVin());
//    }
//
//    public static void main(String[] args) throws IOException {
//        String s = "{\"date\": \"Mar 9, 2017 1:27:39 AM\"}";
//        GsonBuilder builder = new GsonBuilder().setDateFormat("MMM dd, yyyy KK:mm:ss a");
//        Gson gson = builder.create();
//        MyDate myDate = gson.fromJson(s, MyDate.class);
//        System.out.println(myDate.getDate());
//
//    }
//
//    public static class MyDate {
//        public Date getDate() {
//            return date;
//        }
//
//        public void setDate(Date date) {
//            this.date = date;
//        }
//
//        Date date;
//    }
//
//    public Long getSequenceId() {
//        return sequenceId;
//    }
//
//    public void setSequenceId(Long sequenceId) {
//        this.sequenceId = sequenceId;
//    }
//}
