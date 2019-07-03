package com.hkz.part1;

import java.util.concurrent.TimeUnit;

/**
 * @author huangkz
 * @date create in 2018-10-16 18:50
 */
public class ThreadStatus {
    public static void main(String[] args) {
        //TIME_WAITI
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"timeWatting").start();

        //WAITING，线程在 ThreadStatus 类锁上通过 wait 进行等待
        new Thread(()->{
            while (true){
                synchronized (ThreadStatus.class){
                    try {
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Watting").start();
        //线程在 ThreadStatus 加锁后，不会释放锁
        new Thread(new BlockDemo(),"blockDemo1").start();
        new Thread(new BlockDemo(),"blockDemo2").start();

    }
    static class BlockDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
