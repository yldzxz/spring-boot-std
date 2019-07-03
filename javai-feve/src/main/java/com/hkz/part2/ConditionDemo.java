package com.hkz.part2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangkz
 * @date create in 2019-06-26 10:51
 */
public class ConditionDemo {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new ConditonWait().start();
        new ConditonNotify().start();
    }
    static class ConditonWait extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("start conditon await");
                condition.await();
                System.out.println("end conditon await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    static class ConditonNotify extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("start conditon signal");
                condition.signal();
                System.out.println("end conditon signal");
            }finally {
                lock.unlock();
            }
        }
    }
}
