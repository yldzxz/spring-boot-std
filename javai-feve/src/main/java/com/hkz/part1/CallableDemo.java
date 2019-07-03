package com.hkz.part1;

import java.util.concurrent.*;

/**
 * @author huangkz
 * @date create in 2018-10-16 18:24
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        int a = 1;
        a++;
        return "执行结果"+a;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(callableDemo);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
