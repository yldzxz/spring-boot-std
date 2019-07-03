package com.hkz.part1;

/**
 * @author huangkz
 * @date create in 2018-10-16 18:06
 */
public class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("myThread run");
    }
    public static void main(String[] args) {
        Thread m1 = new Thread(new MyThread2());
        Thread m2 = new Thread(new MyThread2());
        m1.start();
        m2.start();
    }
}
