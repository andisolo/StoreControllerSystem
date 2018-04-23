package com.jjkj.administrator.storecontrollersystem.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Administrator
 */
public class TimeUtils {
    public TimeUtils() {
    }

    public static String getTime() {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat mDateFormat = new SimpleDateFormat(pattern, Locale.CHINESE);
        return mDateFormat.format(new Date(System.currentTimeMillis()));
    }

    public static String getTimeAddOneDay(String dateString) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat mDateFormat = new SimpleDateFormat(pattern, Locale.CHINESE);
        try {
            Date date = mDateFormat.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            return mDateFormat.format(calendar.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
