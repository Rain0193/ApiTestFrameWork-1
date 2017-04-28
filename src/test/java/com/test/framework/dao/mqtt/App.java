//package com.test.framework.dao.mqtt;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.beecloud.platform.protocol.core.element.TimeStamp;
//import org.testng.Reporter;
//
//public class App {
//    private String topic;
//    private String threadName;
//
//    public App(String threadName, String topic) {
//        MqttUtil.initConfig();
//        this.topic = topic;
//        this.threadName = threadName;
//        subscirbe();
//    }
//
//    public void connetc(){
//        MqttUtil.connect(threadName);
//    }
//
//    public void subscirbe() {
//        MqttUtil.subscribe(threadName, topic);
//    }
//
//    public void subscribe(String topic) {
//        MqttUtil.subscribe(threadName, topic);
//    }
//
//    public void unsubscribe(String topic) {
//        MqttUtil.unSubscribe(threadName, topic);
//    }
//
//    public void cleanCache() {
//        MqttUtil.cleanCache(threadName);
//    }
//
//    /**
//     * 获取收到的app消息
//     *
//     * @param messageId   messageId做为Key
//     * @param timeOut
//     * @return
//     */
//    public String getMessage(String messageId, int timeOut) {
//        Reporter.log("Get app message " + messageId, true);
//        String message = MqttUtil.getAppMessage(threadName, messageId, timeOut);
//        Reporter.log("Get app message " + messageId + ": " + message, true);
//        return message;
//    }
//
//    public <T> T getMessage(String messageId, Class<T> messageType, int timeOut) {
//        Reporter.log("Get app message " + messageId, true);
//        String message = MqttUtil.getAppMessage(threadName, messageId, timeOut);
//        Reporter.log("Get app message " + messageId + ": " + message, true);
//        String data = null;
//        JSONObject object = JSON.parseObject(message);
//        if (object.keySet().contains("data")) {
//            data = object.getJSONObject("data").toJSONString();
//        }
//        T t = JSON.parseObject(data, messageType);
//        return t;
//    }
//
//    public String getMessageBy(long sequenceId, int timeOut) {
//        String sequenceId1 = String.valueOf(sequenceId);
//        String messageId = threadName + "|" + sequenceId1;
//        Reporter.log("Get app message " + messageId);
//        String message = MqttUtil.getAppMessage(threadName, messageId, timeOut);
//        Reporter.log("Get app message " + messageId + ": " + message, true);
//        return message;
//    }
//
//    public String getMessageByApplicationIdStepIdEventTime(String expectedApplicationId, String expectedStepId,
//                                                           TimeStamp eventTime, int timeOut) {
//        long time = Long.parseLong(Long.toString(eventTime.getDate().getTime()).substring(0, 10).concat("000"));
//        String eventTimenew = Long.toString(time);
//        String key = expectedApplicationId + expectedStepId + eventTimenew;
//        Reporter.log("Get app message " + key, true);
//        String message = MqttUtil.getAppMessage(threadName, key, timeOut);
//        Reporter.log("Get app message " + key + ": " + message, true);
//        return message;
//    }
//
//    public String getMessageByApplicationIdStepIdNotifyMsg(String expectedApplicationId, String expectedStepId,
//                                                           String notifyMsg, int timeOut) {
//
//        String key = expectedApplicationId + expectedStepId + notifyMsg;
//        Reporter.log("Get app message " + key, true);
//        String message = MqttUtil.getAppMessage(threadName, key, timeOut);
//        Reporter.log("Get app message " + key + ": " + message, true);
//        return message;
//    }
//
//
//    public void disconnect() {
//        MqttUtil.disconnect(threadName);
//    }
//
//}