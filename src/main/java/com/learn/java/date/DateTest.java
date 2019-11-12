package com.learn.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/4/20
 * @Time:17:49
 */
public class DateTest {


    public static void main(String[] args) throws ParseException {



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String str1 = "2013-12-06";

        String str2 = "2014-01-05";

        Calendar bef = Calendar.getInstance();

        Calendar aft = Calendar.getInstance();

        bef.setTime(sdf.parse(str1));

        aft.setTime(sdf.parse(str2));

        int surplus = aft.get(Calendar.DATE) - bef.get(Calendar.DATE);

        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);

        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;

        System.out.println(surplus);
        System.out.println(result);
        System.out.println(month);
        System.out.println(surplus);

        surplus = surplus <= 0 ? 1 : 0;

        System.out.println(surplus);

        System.out.println("相差月份：" + (Math.abs(month + result) ));



    }


}
