package com.learn.db.mongodb.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class MongoConnectionUtil {

    /**
     * 不通过认证获取数据库连接对象
     * @return
     */
    public static MongoDatabase getConnection(){

        //连接到mongodb的服务
        MongoClient mongoClient = new MongoClient("localhost",27017);

        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("myNewDatabase");

        return mongoDatabase;
    }

    /**
     * 需要密码方式连接
     * @return
     */
    public static MongoDatabase getConnectionAuthentication(){

        List<ServerAddress> adds = new ArrayList<>();
        ServerAddress address = new ServerAddress("localhost",27017);
        adds.add(address);

        List<MongoCredential> credentials = new ArrayList<>();
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("username","databaseName","password".toCharArray());
        credentials.add(mongoCredential);

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(adds,credentials);

        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("myNewDatabase");

        return mongoDatabase;
    }
}
