package com.orchid0809.thread;

/**
 * Created by orchid0809 on 2018/9/16.
 */
public class ThreadOrderRun {
    

    static Thread t1 = new Thread(()->{
        System.out.println(Thread.currentThread().getName()+"线程执行1");
    });

    static Thread t2 = new Thread(()->{
        System.out.println(Thread.currentThread().getName()+"线程执行2");
    });

    static Thread t3 = new Thread(()->{
        System.out.println(Thread.currentThread().getName()+"线程执行3");
    });

    public static void main(String[] args) {
        t1.start();
        t2.start();
        t3.start();
    }
}
