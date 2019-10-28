package com.learn.db.mongodb;

import com.learn.db.mongodb.utils.MongoConnectionUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/10/28
 * @Time:15:55
 * @Description:查询文档
 */
public class FindBaseDocument {

    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    @Before
    public void init(){
        mongoDatabase = MongoConnectionUtil.getConnection();
        //获取集合
        collection = mongoDatabase.getCollection("inventory");
    }

    /**
     * 指定相等的条件
     * 从inventory集合中选择状态为D的所有文档
     */
    @Test
    public void findDocumentEq(){
        FindIterable findIterable = collection.find(Filters.eq("status","D"));
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 使用查询操作符指定条件
     * 从inventory集合中检索status为A或D的所有文档
     */
    @Test
    public void findDocumentOperators(){
        FindIterable findIterable = collection.find(Filters.in("status","A","D"));
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 指定AND条件
     * AND是隐式的，查询status为A且数量小于30的所有文档
     */
    @Test
    public void findDocumentAnd(){
        FindIterable findIterable = collection.find(Filters.and(Filters.eq("status","A"),Filters.lt("qty",30)));
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 指定OR条件
     * 查询status为A或数量小于30的所有文档
     */
    @Test
    public void findDocumentOr(){
        FindIterable findIterable = collection.find(Filters.or(Filters.eq("status","A"),Filters.lt("qty",30)));
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 指定AND和OR条件
     * 查询status为A且数量小于30或item以字符p开头的所有文档
     */
    @Test
    public void findDocumentOrAnd(){
        FindIterable findIterable = collection.find(
                Filters.and(
                        Filters.eq("status","A"),
                        Filters.or(
                                Filters.lt("qty",30),
                                Filters.regex("item","^p")
                        )
                )
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

}
