package com.wen.date;

import java.util.Date;

/**
 * Created by 21up on 2020/9/29
 */
public class AfterDemo {
    public static void main(String[] args) {
        Date now = new Date();
        Date future=new Date(now.getTime()+2000);
        Date past=new Date(now.getTime()-2000);
        System.out.println(now.after(future));
        System.out.println(now.before(past));
    }
}
