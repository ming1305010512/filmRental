package com.learn.db.mongodb.utils;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/10/28
 * @Time:16:20
 * @Description:
 */
public class MongoUtils {

    /**
     * 打印查询出的结果
     * @param findIterable
     */
    public static void print(FindIterable<Document> findIterable){
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
}
