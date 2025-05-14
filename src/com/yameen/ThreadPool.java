package com.yameen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i=0;i<10;i++){
            executorService.submit(() -> {
                System.out.println("Task Executed by "+ Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
