package com.hkz.part1;

/**
 * @author huangkz
 * @date create in 2018-10-16 18:02
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("myThread run");
    }

    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        m1.start();
        m2.start();
    }
}
