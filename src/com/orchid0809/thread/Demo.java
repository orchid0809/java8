package com.orchid0809.thread;

/**
 * Created by orchid0809 on 2018/9/1.
 */
public class Demo {

    private int signal = 0;


    public synchronized void a(){
        while(signal !=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        notifyAll();
        System.out.println("a");
    }

    public synchronized void b(){
        while(signal !=1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        notifyAll();
        System.out.println("b");
    }

    public synchronized void c(){
        while(signal !=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal=0;
        notifyAll();
        System.out.println("c");
    }

    private static class A implements Runnable{

        private Demo demo;
        public A(Demo demo){
            this.demo = demo;
        }
        @Override
        public void run() {
            while(true){
                demo.a();
            }

        }
    }

    private static class B implements Runnable{

        private Demo demo;
        public B(Demo demo){
            this.demo = demo;
        }
        @Override
        public void run() {
            while(true){
                demo.b();
            }

        }
    }

    private static class C implements Runnable{

        private Demo demo;
        public C(Demo demo){
            this.demo = demo;
        }
        @Override
        public void run() {
            while(true){
                demo.c();
            }

        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(new A(demo)).start();
        new Thread(new B(demo)).start();
        new Thread(new C(demo)).start();
    }





}
