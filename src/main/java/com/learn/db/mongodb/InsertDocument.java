package com.learn.db.mongodb;

import com.learn.db.mongodb.utils.MongoConnectionUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class InsertDocument {

    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    @Before
    public void init(){
        mongoDatabase = MongoConnectionUtil.getConnection();
        //获取集合
       collection = mongoDatabase.getCollection("test");
    }

    /**
     * 插入一条记录
     */
    @Test
    public void insertOneDocument(){

        Document canvas = new Document("item","canvas")
                .append("qty",100)
                .append("tags", singletonList("cotton"));

        Document size = new Document("h",28)
                .append("w",35.5)
                .append("uom","cm");

        canvas.put("size",size);

        collection.insertOne(canvas);

    }

    @Test
    public void insertManyDocument(){

        Document journal = new Document("item", "journal")
                .append("qty", 25)
                .append("tags", asList("blank", "red"));
        Document journalSize = new Document("h", 14)
                .append("w", 21)
                .append("uom", "cm");
        journal.put("size", journalSize);


        Document mat = new Document("item", "mat")
                .append("qty", 85)
                .append("tags", singletonList("gray"));

        Document matSize = new Document("h", 27.9)
                .append("w", 35.5)
                .append("uom", "cm");
        mat.put("size", matSize);

        Document mousePad = new Document("item", "mousePad")
                .append("qty", 25)
                .append("tags", asList("gel", "blue"));

        Document mousePadSize = new Document("h", 19)
                .append("w", 22.85)
                .append("uom", "cm");
        mousePad.put("size", mousePadSize);

        collection.insertMany(asList(journal,mat,mousePad));
        System.out.println("===========插入成功============");
    }


    /**
     * 查询指定条件的文档
     */
    @Test
    public void findDocument(){
        //指定查询过滤器
        Bson filter = Filters.eq("item","canvas");
        FindIterable<Document> findIterable = collection.find(filter);

        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 查询指定条件的文档
     */
    @Test
    public void findAllDocument(){
        FindIterable<Document> findIterable = collection.find();

        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    @Test
    public void deleteDocument(){
        collection.deleteMany(new Document());
        System.out.println("===========删除成功=============");
    }


}
