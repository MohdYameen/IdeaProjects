package com.yameen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Resource {
    public synchronized void test1() {
        System.out.println("Inside Test1 Method");
        try {
            Thread.sleep(Long.MAX_VALUE);;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void test2() {
        System.out.println("Inside Test2 Method");
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task1 implements Runnable {
    private Resource resource;

    public Task1(Resource resource) { this.resource = resource; }

    @Override
    public void run() {
        resource.test1();
        resource.test2();
        System.out.println("Invoked Test2 Method from Task1");
    }
}

class Task2 implements Runnable {
    private Resource resource;

    public Task2(Resource resource) { this.resource = resource; }

    @Override
    public void run() {
        resource.test2();
        resource.test1();
        System.out.println("Invoked Test1 Method from Task2");
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Resource resource =  new Resource();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(new Task1(resource));
        Thread t2 = new Thread(new Task2(resource));
        t1.start();
        t2.start();
    }
}


////
//Inside Test1 Method
//Inside Test2 Method


