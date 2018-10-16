package com.orchid0809.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by orchid0809 on 2018/8/31.
 */
public class Aqs {



    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
