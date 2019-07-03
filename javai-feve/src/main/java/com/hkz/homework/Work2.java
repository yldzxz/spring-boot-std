package com.hkz.homework;

import java.io.IOException;

/**
 * @author huangkz
 * @date create in 2019-05-28 14:27
 */
public class Work2 {
    static Integer count=0;
    public static void incr(){
        synchronized (count) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->Work2.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println("result:"+count);
    }
}
