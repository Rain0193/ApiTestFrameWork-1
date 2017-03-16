package com.test.framework.dao.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author hong.lin
 * @description
 * @date 2016/11/29.
 */
public class RedisManager {
    private String host;
    private int port;
    private String auth;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "RedisManager{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", auth='" + auth + '\'' +
                '}';
    }

    public Jedis getRedisClient(){
        Jedis jedis = new JedisPool(host,port).getResource();
        return jedis;
    }
}
