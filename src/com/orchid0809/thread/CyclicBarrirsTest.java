package com.orchid0809.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by orchid0809 on 2018/9/1.
 */
public class CyclicBarrirsTest {

    public void meeting(CyclicBarrier cyclicBarrier){
        System.out.println(Thread.currentThread().getName()+"等待开会");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("开会了");
            }
        });

        CyclicBarrirsTest test = new CyclicBarrirsTest();
        for(int i= 0 ;i < 10 ;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.meeting(cyclicBarrier);
                }
            }).start();
        }
    }
}
