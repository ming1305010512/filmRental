package com.learn.db.mongodb;

import com.learn.db.mongodb.utils.MongoConnectionUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Arrays.asList;

public class FindArrayDocument {

    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    @Before
    public void init(){
        mongoDatabase = MongoConnectionUtil.getConnection();
        //获取集合
        collection = mongoDatabase.getCollection("inventory");
    }

    /**
     * 匹配一个数组
     */
    @Test
    public void findArrayDocument(){
        System.out.println("查询所有字段标记值是一个数组的文档，该数组恰好有两个元素，“红色”和“空白”，它们的顺序是指定的:");
        FindIterable<Document> findIterable = collection.find(
                eq("tags",asList("red","blank"))
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        System.out.println("找到同时包含“红色”和“空白”元素的数组，而不考虑数组中的顺序或其他元素，则使用$all操作符:");
        FindIterable<Document> findIterable2 = collection.find(
                eq("tags",asList("red","blank"))
        );
        MongoCursor cursor2 = findIterable2.iterator();
        while (cursor2.hasNext()){
            System.out.println(cursor2.next());
        }
    }

}
