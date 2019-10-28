package com.learn.db.mongodb;

import com.learn.db.mongodb.utils.MongoConnectionUtil;
import com.mongodb.Block;
import com.mongodb.Function;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static com.mongodb.client.model.Filters.*;
import static java.util.Arrays.asList;
/**
 * @Created with IDEA
 * @author:龙鸣
 * @Date:2019/10/28
 * @Time:15:55
 * @Description:查询一个数组
 */
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
                Filters.all("tags",asList("red","blank"))
        );
        MongoCursor cursor2 = findIterable2.iterator();
        while (cursor2.hasNext()){
            System.out.println(cursor2.next());
        }
    }

    /**
     * 查询一个数组元素
     * 结果：
     * 查询tags数组字段里包含字符串red的文档:
     * Document{{_id=5db3e900371e8be988f54562, item=journal, qty=25.0, tags=[blank, red], dim_cm=[14.0, 21.0]}}
     * Document{{_id=5db3e900371e8be988f54563, item=notebook, qty=50.0, tags=[red, blank], dim_cm=[14.0, 21.0]}}
     * Document{{_id=5db3e900371e8be988f54564, item=paper, qty=100.0, tags=[red, blank, plain], dim_cm=[14.0, 21.0]}}
     * Document{{_id=5db3e900371e8be988f54565, item=planner, qty=75.0, tags=[blank, red], dim_cm=[22.85, 30.0]}}
     * 查询数组dim_cm包含至少一个值大于25的元素的所有文档:
     * Document{{_id=5db3e900371e8be988f54565, item=planner, qty=75.0, tags=[blank, red], dim_cm=[22.85, 30.0]}}
     */
    @Test
    public void findOneArrayElementDocument(){
        System.out.println("查询tags数组字段里包含字符串red的文档:");
        FindIterable<Document> findIterable = collection.find(
                eq("tags","red")
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        System.out.println("查询数组dim_cm包含至少一个值大于25的元素的所有文档:");
        FindIterable<Document> findIterable2 = collection.find(
                gt("dim_cm", 25)
        );
        MongoCursor cursor2 = findIterable2.iterator();
        while (cursor2.hasNext()){
            System.out.println(cursor2.next());
        }
    }

    /**
     * 为数组元素指定多个条件
     */
    @Test
    public void findArrayDocumentWithManyCondition(){
        System.out.println("dim_cm数组包含在某些组合中满足查询条件的元素，一个元素可以满足大于15的条件，另一个元素可以满足小于20的条件，或者单个元素可以同时满足这两个条件:");
        FindIterable<Document> findIterable = collection.find(
                and(
                        gt("dim_cm",15),
                        lt("dim_cm",20)
                )
        );
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        //使用$elemMatch操作符指定数组元素上的多个条件，使至少一个数组元素满足所有指定的条件。
        System.out.println("查询dim_cm数组中至少包含一个大于($gt) 22和小于($lt) 30的元素的文档:");
        FindIterable<Document> findIterable2 = collection.find(
                elemMatch("dim_cm",Document.parse("{ $gt: 22, $lt: 30 }"))
        );
        MongoCursor cursor2 = findIterable2.iterator();
        while (cursor2.hasNext()){
            System.out.println(cursor2.next());
        }

        //指定数组元素的索引位置
        System.out.println("查询数组dim_cm中第二个元素大于25的所有文档");
        FindIterable<Document> findIterable3 = collection.find(
                gt("dim_cm.1",25)
        );
        MongoCursor cursor3 = findIterable3.iterator();
        while (cursor3.hasNext()){
            System.out.println(cursor3.next());
        }

        //按数组长度查询数组
        System.out.println("选择数组tags有3个元素的文档");
        FindIterable<Document> findIterable4 = collection.find(
                size("tags",3)
        );
        MongoCursor cursor4 = findIterable4.iterator();
        while (cursor4.hasNext()){
            System.out.println(cursor4.next());
        }
    }

}
