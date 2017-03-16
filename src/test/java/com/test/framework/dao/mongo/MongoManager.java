package com.test.framework.dao.mongo;


import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;

import java.net.UnknownHostException;

public  class MongoManager extends MongoClient{
	private String host;
	private int port;
	private int poolSize;
	private int blockSize;

	private MongoClient mongoClient;


	private MongoManager() throws UnknownHostException{
		super();
	}


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


	public int getPoolSize() {
		return poolSize;
	}


	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}


	public int getBlockSize() {
		return blockSize;
	}


	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}


	public  MongoClient getMongoClient() {
		try {
			mongoClient = new MongoClient(host, port);
			MongoOptions opt = mongoClient.getMongoOptions();
			opt.connectionsPerHost = poolSize;
			opt.threadsAllowedToBlockForConnectionMultiplier = blockSize;
		}catch (MongoException e) {
			throw new RuntimeException(e);
		}
		return mongoClient;
	}
}
