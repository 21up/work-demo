package com.wen.this_demo;

/**
 * Created by 21up on 2020/9/27
 */
public class Son extends Parent{

    public static void main(String[] args) {
        Parent son=new Son();
        son.printlb();
    }

    @Override
    public void printlb() {
        System.out.println("这是子类");
    }
}
