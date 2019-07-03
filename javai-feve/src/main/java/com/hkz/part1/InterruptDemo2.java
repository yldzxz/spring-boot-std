package com.hkz.part1;

import java.util.concurrent.TimeUnit;

/**
 * @author huangkz
 * @date create in 2018-10-18 11:00
 */
public class InterruptDemo2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            boolean flag = Thread.currentThread().isInterrupted();
            while(!flag){
                System.out.println("before:" + flag);
                Thread.interrupted();
                System.out.println("after:" + flag);
            }
        },"interruptThread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("before:" + thread.isInterrupted());

    }
}
