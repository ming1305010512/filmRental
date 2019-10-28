package com.learn.db.mongodb;

import com.learn.db.mongodb.utils.MongoConnectionUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static com.mongodb.client.model.Filters.*;
/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/7/18
 * @Time:15:18
 */
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
        //查询instock中的元素与指定文档匹配的所有文档（精确匹配，包括字段顺序）
        FindIterable<Document> findIterable = collection.find(
                eq("instock",Document.parse("{warehouse:'A', qty: 5 }"))
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 在文档数组中的字段上指定查询条件
     */
    @Test
    public void findDocumentWithEmbedArrayByCondition(){
        System.out.println("指定嵌入在文档数组中的字段的查询条件");
        /**
         *指定嵌入在文档数组中的字段的查询条件
         */
        //选择instock数组中至少有一个嵌入文档的所有文档，其中包含值小于或等于20的字段qty
        FindIterable<Document> findIterable = collection.find(
                lte("instock.qty",20)
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        System.out.println("使用数组索引查询嵌入文档中的字段");
        /**
         * 使用数组索引查询嵌入文档中的字段
         */
        //选择instock数组中第一个元素为文档的所有文档，其中包含值小于或等于20的字段qty
        FindIterable<Document> findIterable2 = collection.find(
                lte("instock.0.qty",20)
        );
        MongoCursor cursor2 = findIterable2.iterator();
        while (cursor2.hasNext()){
            System.out.println(cursor2.next());
        }

    }

    /**
     * 为文档数组指定多个条件
     */
    @Test
    public void findDocumentWithEmbedArrayByMultiCondition(){
        System.out.println("一个嵌套文档满足嵌套字段规范中的多个查询条件(1)");
        /**
         * 一个嵌套文档满足嵌套字段规范中的多个查询条件
         */
        //查询instock数组中至少有一个嵌入文档的文档，其中包含字段qty大于10，小于或等于20
        FindIterable<Document> findIterable = collection.find(
                elemMatch("instock", Document.parse("{ qty: { $gt: 10, $lte: 20 } }"))
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
        System.out.println("一个嵌套文档满足嵌套字段规范中的多个查询条件(2)");
        //查询instock数组中至少有一个嵌入文档的文档，其中包含字段qty等于5，字段仓库等于A
        FindIterable<Document> findIterable2 = collection.find(
                elemMatch("instock", Document.parse("{ qty: 5, warehouse: 'A' }"))
        );
        MongoCursor cursor2 = findIterable2.iterator();
        while (cursor2.hasNext()){
            System.out.println(cursor2.next());
        }
    }

}
