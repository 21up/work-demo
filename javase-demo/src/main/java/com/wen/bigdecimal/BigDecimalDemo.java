package com.wen.bigdecimal;

import java.math.BigDecimal;

/**
 * Created by 21up on 2020/9/23
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal b1=new BigDecimal("10");
        BigDecimal b2=new BigDecimal("-2");
        System.out.println(b1.subtract(b2));
    }
}
