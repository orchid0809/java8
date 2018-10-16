package com.orchid0809.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by orchid0809 on 2018/9/2.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        MyTask task1 = new MyTask("任务1");
        MyTask task2 = new MyTask("任务2");
        MyTask task3 = new MyTask("任务3");
        MyTask task4 = new MyTask("任务4");
        MyTask task5 = new MyTask("任务5");
        MyTask task6 = new MyTask("任务6");

        pool.execute(task1);
        pool.execute(task2);
        pool.execute(task3);
        pool.execute(task4);
        pool.execute(task5);
       pool.execute(task6);

        pool.shutdown();
    }
}
