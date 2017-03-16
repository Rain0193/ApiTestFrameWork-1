package com.test.framework.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtil {

    private static final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String SQL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static String format(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return dateFormat.format(date);
    }

    public static String convertDateToSqlString(Date date) {
        SimpleDateFormat sqlFormatter = new SimpleDateFormat(SQL_FORMAT);
        return sqlFormatter.format(date);
    }

    public static String convertDateToUTCString(Date date) {
        SimpleDateFormat isoFormatter = new SimpleDateFormat(ISO_FORMAT);
        TimeZone utc = TimeZone.getTimeZone("UTC");
        isoFormatter.setTimeZone(utc);
        return isoFormatter.format(date);
    }

    public static Date convertUTCStringToDate(String utcDateString) throws ParseException {
        SimpleDateFormat isoFormatter = new SimpleDateFormat(ISO_FORMAT);
        return isoFormatter.parse(utcDateString);
    }

    public static Date getDateWithDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.set(year, month, day, 0, 0, 0);
        newCalendar.set(Calendar.MILLISECOND, 0);
        return newCalendar.getTime();
    }

    public static Date addSeconds(Date date, int seconds) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        date = calendar.getTime();
        return date;
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

}
