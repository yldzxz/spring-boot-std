package com.hkz.part2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangkz
 * @date create in 2019-06-24 10:28
 */
public class LockExample {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        System.out.println(1&(1<<16-1));
    }
    public void demo1(){
        lock.lock();
        
        lock.unlock();
    }
}
