package com.learn.java.date.dateCompare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/8/8
 * @Time:9:39
 * @Description: 日期大小比较
 */
public class DateCompareTest {

    public static void main(String[] args) throws ParseException {
        String date1Str = "2019-08-07";
        String date2Str = "2019-08-08";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1Str);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2Str);
        if (date1.getTime()<date2.getTime()){
            System.out.println("date1比date2小");
        }else {
            System.out.println("和预期不符");
        }
    }
}
