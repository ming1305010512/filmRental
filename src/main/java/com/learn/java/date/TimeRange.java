package com.learn.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/3/29
 * @Time: 9:48
 * @Description:
 */
public class TimeRange {

    public static void main(String[] args) throws ParseException {
        String startDateStr = "2021-1-30";
        String endDateStr = "2021-2-27";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(startDateStr);
        Date endDate = simpleDateFormat.parse(endDateStr);
        List<String> months = getRangeDatesWithMonth(startDate,endDate,"MM");
        months.stream().forEach(a->{
            System.out.println(a);
        });

//        String startDateStr = "2021-1-29";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = simpleDateFormat.parse(startDateStr);
//        Calendar cd = Calendar.getInstance();
//        cd.setTime(startDate);
//        cd.add(Calendar.MONTH, 1);
//        Date aa = cd.getTime();
//        String addMonthDate = simpleDateFormat.format(aa);
//        System.out.println(addMonthDate);
    }

    public static List<String> getRangeDatesWithMonth(Date startDate, Date endDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        List<String> list = new ArrayList<String>();
        Calendar cd = Calendar.getInstance();
        while(startDate.getTime() <= endDate.getTime()) {
            list.add(sdf.format(startDate));
            cd.setTime(startDate);
            cd.add(Calendar.MONTH, 1);
            startDate = cd.getTime();
        }
        return list;
    }
}
