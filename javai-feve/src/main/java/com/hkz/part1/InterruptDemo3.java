package com.hkz.part1;

import java.util.concurrent.TimeUnit;

/**
 * @author huangkz
 * @date create in 2018-10-18 11:20
 */
public class InterruptDemo3 {
    private static boolean flag = true;
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (flag){
                i++;
                System.out.println(i);
            }
        },"thread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        flag  = false;
    }

}
