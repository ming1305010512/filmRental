package com.learn.java.date.dateCompare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/8/8
 * @Time:10:09
 * @Descriptio:获取集合中日期的最大值
 */
public class GetMaxDate {

    public static void main(String[] args) throws ParseException {
        String date1Str = "2019-08-07";
        String date2Str = "2019-08-08";
        String date3Str = "2019-08-10";
        String date4Str = "2019-08-09";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1Str);
        Date date2 = null;
        Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(date3Str);
        Date date4 = new SimpleDateFormat("yyyy-MM-dd").parse(date4Str);
        List<Date> glDates = new ArrayList<>();
        glDates.add(date1);
        glDates.add(date2);
        glDates.add(date3);
        glDates.add(date4);
        Date maxDate = null;
        for (int i=0;i<glDates.size();i++){
            Date date = glDates.get(i);
            if (date!=null&&maxDate==null){
                maxDate = date;
            }
            if (date!=null){
                if (date.getTime()>maxDate.getTime()){
                    maxDate = date;
                }
            }
        }
        System.out.println(maxDate);
    }
}
