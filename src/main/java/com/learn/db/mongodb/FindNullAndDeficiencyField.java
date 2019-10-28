package com.learn.db.mongodb;

import com.learn.db.mongodb.utils.MongoConnectionUtil;
import com.learn.db.mongodb.utils.MongoUtils;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.BsonType;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.slice;

/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/10/28
 * @Time:16:36
 * @Description:查询Null和缺失字段
 */
public class FindNullAndDeficiencyField {

    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    @Before
    public void init(){
        mongoDatabase = MongoConnectionUtil.getConnection();
        //获取集合
        collection = mongoDatabase.getCollection("inventory");
    }

    /**
     * 相等过滤器
     */
    @Test
    public void findOne(){
        //查询要么包含值为null的item字段，要么不包含item字段
        FindIterable<Document> findIterable = collection.find(
                eq("item",null)
        );
        MongoUtils.print(findIterable);
    }

    /**
     * 类型检查
     */
    @Test
    public void findTwo(){
        //查询只匹配包含值为null的item字段的文档
        FindIterable<Document> findIterable = collection.find(
               type("item", BsonType.NULL)
        );
        MongoUtils.print(findIterable);
    }

    /**
     * 存在检查
     */
    @Test
    public void findThree(){
        //查询匹配不包含item字段的文档:
        FindIterable<Document> findIterable = collection.find(
                exists("item", false)
        );
        MongoUtils.print(findIterable);
    }
}
