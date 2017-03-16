package com.test.framework.dao.mongo;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MongoBaseDao {
    @Autowired
    @Qualifier("mongoClient")
    private MongoClient mongoClient;

    public MongoBaseDao() {

    }

    public DB getDB(String dbName) {
        DB db = mongoClient.getDB(dbName);
        return db;
    }

    public DBCollection getCollection(String dbName, String collName) {
        return getDB(dbName).getCollection(collName);
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    /**
     * 查询数据返回List<Bean>
     *
     * @param
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public List<Object> find(String dbName, String collName, Map<String, Object> map, Class classType) throws IllegalAccessException, InvocationTargetException {
        List<Object> list = new ArrayList<Object>();
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.putAll(map);    //查询条件
        Cursor cursor = getCollection(dbName, collName).find(basicDBObject);
        Gson gson = new Gson();
        while (cursor.hasNext()) {
            DBObject dBobject = cursor.next();
            String json = dBobject.toString();
            list.add(gson.fromJson(json, classType));
        }
        return list;
    }

    public List<Object> findAndSort(String dbName, String collName, Map<String, Object> map,
                                    String sortField, Integer order, Class classType) throws IllegalAccessException, InvocationTargetException {
        List<Object> list = new ArrayList<Object>();
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.putAll(map);    //查询条件
        Cursor cursor = getCollection(dbName, collName).find(basicDBObject).sort(new BasicDBObject(sortField, order));
        Gson gson = new Gson();
        while (cursor.hasNext()) {
            DBObject dBobject = cursor.next();
            String json = dBobject.toString();
            list.add(gson.fromJson(json, classType));
        }
        return list;
    }


    /**
     * 查询数据返回List<DBObject>
     *
     * @param dbName
     * @param collName
     * @param map
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public List<DBObject> find(String dbName, String collName, Map<String, Object> map) throws IllegalAccessException, InvocationTargetException {
        List<DBObject> list = new ArrayList<DBObject>();
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.putAll(map);    //查询条件
        Cursor cursor = getCollection(dbName, collName).find(basicDBObject);
        while (cursor.hasNext()) {
            DBObject dBobject = cursor.next();
            list.add(dBobject);
        }
        return list;
    }


    /**
     * 查询总条数
     *
     * @param dbName
     * @param collName
     * @return
     * @throws DataAccessException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public int countAll(String dbName, String collName) throws DataAccessException,
            InstantiationException, IllegalAccessException {
        return this.getCollection(dbName, collName).find().count();
    }

    public void insert(String dbName, String collName, String json) {
        DBObject dbObject = (DBObject) JSON.parse(json);
        getCollection(dbName, collName).insert(dbObject, WriteConcern.ACKNOWLEDGED);
    }

}

