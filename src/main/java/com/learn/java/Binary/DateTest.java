package com.learn.java.Binary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/9/7
 * @Time:15:14
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse("2019-08-01");
        Date date2 = format.parse("2019-09-01");
        Integer integer = getDifferenceOfMonth(date1,date2);
        System.out.println(integer);
    }

    public static Integer getDifferenceOfMonth(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int result = calendar1.get(Calendar.MONTH) - calendar2.get(Calendar.MONTH);
        int month = (calendar1.get(Calendar.YEAR) - calendar2.get(Calendar.YEAR)) * 12;
        int surplus = calendar1.get(Calendar.MONTH) - calendar2.get(Calendar.MONTH);
        return surplus;
    }
}
