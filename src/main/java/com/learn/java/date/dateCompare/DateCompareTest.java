package com.learn.java.date.dateCompare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ThreadPoolExecutor;

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

        Date nowDate = new Date();
        String dateStr3 = "2021-3-31";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        if (date3.getTime()<zero.getTime()){
            System.out.println("date3比nowDate小");
        }else if (date3.getTime()==zero.getTime()){
            System.out.println("相等");
        }else {
            System.out.println("date3比nowDate大");
        }
    }
}
