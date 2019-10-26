package com.learn.db.mongodb;

import com.learn.db.mongodb.utils.MongoConnectionUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

public class FindEmbedDocumentArray {

    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    @Before
    public void init(){
        mongoDatabase = MongoConnectionUtil.getConnection();
        //获取集合
        collection = mongoDatabase.getCollection("inventory");
    }


    /**
     * 查询嵌套在数组中的文档
     */
    @Test
    public void findDocumentWithEmbedArray(){

    }
}
