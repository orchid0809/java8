package com.orchid0809.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by orchid0809 on 2018/9/1.
 */
public class SemphoreTest {

    public void test(Semaphore semaphore){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"is run");

        semaphore.release();
    }


    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        SemphoreTest test = new SemphoreTest();
        Semaphore semaphore = new Semaphore(10);
        for(int i = 0;i < 300;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.test(semaphore);
                }
            }).start();
        }
    }
}
