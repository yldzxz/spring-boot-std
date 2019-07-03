package com.hkz.part1;

import java.util.concurrent.TimeUnit;

/**
 * 中断线程
 * @author huangkz
 * @date create in 2018-10-18 10:49
 */
public class InterruptDemo {

    public static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                i++;
                System.out.println("num:" + i);
            }
        }
        ,"thread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
