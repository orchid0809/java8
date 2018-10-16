package com.orchid0809.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by orchid0809 on 2018/9/1.
 */
public class Demo2 {

    //ThreadLocal

    private int signal = 0;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void a() {
        lock.lock();
        while (signal != 0) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        b.signal();
        System.out.println("a");
        lock.unlock();
    }

    public void b() {
        lock.lock();
        while (signal != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        c.signal();
        System.out.println("b");
        lock.unlock();
    }

    public void c() {
        lock.lock();
        while (signal != 2) {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal = 0;
        a.signal();
        System.out.println("c");
        lock.unlock();
    }

    private static class A implements Runnable {

        private Demo2 demo;

        public A(Demo2 demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            while (true) {
                demo.a();
            }

        }
    }

    private static class B implements Runnable {

        private Demo2 demo;

        public B(Demo2 demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            while (true) {
                demo.b();
            }

        }
    }

    private static class C implements Runnable {

        private Demo2 demo;

        public C(Demo2 demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            while (true) {
                demo.c();
            }

        }
    }

    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        new Thread(new A(demo)).start();
        new Thread(new B(demo)).start();
        new Thread(new C(demo)).start();
    }


}
