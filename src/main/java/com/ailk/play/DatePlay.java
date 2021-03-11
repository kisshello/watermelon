package com.ailk.play;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: wanghk3
 * @time: 2020/6/4 17:45
 */
public class DatePlay {
    public static void main(String[] args) {
        Date date= new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        System.out.println("=========================");
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.MONTH));
        c.set(2020,6,22);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        c.add(Calendar.MONTH,3);
        System.out.println(c.get(Calendar.MONTH));
    }
}