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

import static com.mongodb.client.model.Filters.*;
/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/10/28
 * @Time:15:55
 * @Description:查询嵌入的文档记录
 */
public class FindEmbedDocument {

    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    @Before
    public void init(){
        mongoDatabase = MongoConnectionUtil.getConnection();
        //获取集合
        collection = mongoDatabase.getCollection("inventory");
    }

    /**
     * 匹配内嵌文档
     * 查询size等于文档{h: 14, w: 21, uom: "cm"}的所有文档
     */
    @Test
    public void findEmbedDocument(){
        FindIterable findIterable = collection.find(eq("size",Document.parse("{h: 14, w: 21, uom: \"cm\"}")));
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    /**
     * 匹配内嵌字段
     */
    @Test
    public void findEmbedFieldDocument(){
        //查询size字段中uom等于in的所有文档
        System.out.println("==========查询size字段中uom等于in的所有文档=============");
        FindIterable findIterable = collection.find(eq("size.uom","in"));
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        System.out.println("============查询嵌套字段h小于15，嵌套字段uom等于“in”，状态字段等于“D”的所有文档=================");
        FindIterable findIterable2 = collection.find(
                and(
                        lt("size.h", 15),
                        eq("size.uom", "in"),
                        eq("status", "D")
                )
        );
        MongoCursor cursor2 = findIterable2.iterator();
        while (cursor2.hasNext()){
            System.out.println(cursor2.next());
        }
    }

    @Test
    public void deleteDocument(){
        collection.deleteMany(new Document());
        System.out.println("===========删除成功=============");
    }
}
