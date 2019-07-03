package com.hkz.part2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author huangkz
 * @date create in 2019-06-20 16:21
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread(new Wait(),"wait");
        wait.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notify = new Thread(new Notify(),"notify");
        notify.start();

    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    // 当条件不满足时，继续wait，同时释放了lock的锁
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //满足条件
                    System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized(lock){
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notify();
                flag = false; //满足条件
            }
        }
    }
}
