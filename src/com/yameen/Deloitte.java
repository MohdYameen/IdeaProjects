package com.yameen;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deloitte extends Thread{


    // Deloitte interview on 14th Aug 2025, failed miserably
    public static void main(String[] args) throws Exception {
        String str = "qwertytrewq";

        Map<Character, Long> hmap = str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



//        Stream stream = str.toCharArray().stream()

//        List<Character> list = new ArrayList<>();
//        for(char c: str.toCharArray()){
//            list.add(c);
//
//            hmap.put(c, hmap.getOrDefault(c, 0)+1);
//
//        }


        int [] array = {1,2,2,3,4,5,6,7,8,9};
        // 2, 4, 6, 8

        List<Integer> list = new ArrayList<>();

//        Integer a = list.stream()

//        int i = 10;
//        Integer I = i;



        Integer sol = Arrays.stream(array)
                .boxed()
                .filter(i-> i%2 == 0)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(sol);

//        System.out.println(sol.getAsInt());






//


        // Reflection, call method using reflection in Java
        Class myClass = MyClass.class;
        Object obj2 = myClass.getDeclaredConstructor().newInstance();
        Method method = myClass.getMethod("getInt");
        System.out.println(method.invoke(obj2));
        Method nameMethod = myClass.getMethod("printName", String.class);
        nameMethod.invoke(obj2, "Yameen");

//        System.out.println(myClass);

//        myClass.getMethods();
//        System.out.println(myClass.getMethods());
//        ExecutorService executorService =


        //
        Thread t1 = new Thread(() ->{
            try{
                sleep1();
                System.out.println(Thread.currentThread().getName() + " complete");
            } catch (Exception e){
            }
        }, "Thread1");
        Thread t2 = new Thread(() ->{
            try{
                sleep2();
                System.out.println(Thread.currentThread().getName() + " complete");
            } catch(Exception e){
            }
        }, "Thread2");


        // start both thread
        t1.start();
        t2.start();

        // wait for all thread to complete
        t1.join();
        t2.join();

        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();

        for(Thread t: threadSet){
            System.out.println(t.getName());
        }


        System.out.println("All completed");



//
//        System.out.println(Thread.currentThread());

    }

    public static void sleep1() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void sleep2() throws InterruptedException {
        Thread.sleep(2000);
    }
}

class MyClass{
    private int a = 10;

    public int getInt(){
        return a;
    }

    public void printName(String name){
        System.out.println("My name is "+ name);
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a=" + a +
                '}';
    }
}
