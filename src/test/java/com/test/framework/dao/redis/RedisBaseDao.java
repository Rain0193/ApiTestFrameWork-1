package com.test.framework.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

/**
 * @author hong.lin
 * @description
 * @date 2016/11/29.
 */
@Repository
public class RedisBaseDao {
    @Autowired
    @Qualifier("redisClient")
    private Jedis redisClient;

    public void selectDB(int index){
        redisClient.select(index);
    }

    /**
     * 对key赋值（insert）
     * @param key
     * @param value
     */
    public void setValueBykey(String key,String value){
        redisClient.set(key, value);
    }

    /**
     * 获取Key对应的值
     * @param key
     * @return
     */
    public String getValueBykey(String key){
        return redisClient.get(key);
    }

    /**
     * 删除对应的Key
     * @param key
     */
    public void delValueBykey(String key){
        redisClient.del(key);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean isKeyExists(String key){
        return redisClient.exists(key);
    }

    /**
     * 关闭
     */
    public void shutDown(){
        redisClient.shutdown();
    }
}
