package com.learn.db.mongodb;

import com.learn.db.mongodb.utils.MongoConnectionUtil;
import com.learn.db.mongodb.utils.MongoUtils;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.slice;

/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/10/28
 * @Time:15:55
 * @Description:查询返回指定的字段
 */
public class FindSpecifyField {

    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    @Before
    public void init(){
        mongoDatabase = MongoConnectionUtil.getConnection();
        //获取集合
        collection = mongoDatabase.getCollection("inventory");
    }

    /**
     * 只返回指定的字段和_id字段
     */
    @Test
    public void findOne(){
        FindIterable<Document> findIterable = collection.find(
               eq("status","A")
        ).projection(Projections.fields(
                Projections.include("item","status")
                )
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 抑制_id字段
     */
    @Test
    public void findTwo(){
        FindIterable<Document> findIterable = collection.find(
                eq("status","A")
        ).projection(Projections.fields(
                Projections.include("item","status"),excludeId()
                )
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    /**
     * 返回除被排除的字段之外的所有字段
     */
    @Test
    public void findThree(){
        FindIterable<Document> findIterable = collection.find(
                eq("status","A")
        ).projection(Projections.fields(
                Projections.exclude("item","status")
                )
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 返回嵌入文档中的特定字段
     */
    @Test
    public void findFour(){
        FindIterable<Document> findIterable = collection.find(
                eq("status","A")
        ).projection(Projections.fields(
                Projections.include("item","status","size.uom")
                )
        );
        MongoUtils.print(findIterable);
    }

    /**
     * 在嵌入式文档值禁用特定字段
     */
    @Test
    public void findFive(){
        FindIterable<Document> findIterable = collection.find(
                eq("status","A")
        ).projection(Projections.fields(
                Projections.exclude("size.uom")
                )
        );
        MongoUtils.print(findIterable);
    }

    /**
     * 在数组中对嵌入文档上的投影
     */
    @Test
    public void findSix(){
        FindIterable<Document> findIterable = collection.find(
                eq("status","A")
        ).projection(Projections.fields(
                Projections.include("item","status","instock.qty")
                )
        );
        MongoUtils.print(findIterable);
    }

    /**
     * 在返回的数组项目中指定对应数组元素
     */
    @Test
    public void findSeven(){
        //返回instock数组中的最后一个元素
        FindIterable<Document> findIterable = collection.find(
                eq("status","A")
        ).projection(Projections.fields(
                Projections.include("item","status"),slice("instock",-1)
                )
        );
        MongoUtils.print(findIterable);
    }
}
