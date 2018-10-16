package com.orchid0809.thread;

/**
 * Created by orchid0809 on 2018/9/2.
 */
public class MyTask extends Thread {
    private String taskName;

    public MyTask(String name){
        this.taskName = name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行了任务"+taskName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
