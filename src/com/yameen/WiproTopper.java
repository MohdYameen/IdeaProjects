package com.yameen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class WiproTopper {

    static int age;
    static String name;

    public static void main(String ... args){
//        Scanner sc = new Scanner(System.in);
//        int s = sc.nextInt();
//        ArrayList <Integer> arlist = new ArrayList<>();
//        for(int i = 0; i<s;i++){
//            int temp =sc.nextInt();
//            arlist.add(temp);
//        }
//        int n = sc.nextInt();
//        Collections.sort(arlist);
//        for (int i =s-1; i >= s - n;i--){
//            System.out.print(arlist.get(i) + " ");
//        }
//        System.out.println();

        WiproTopper.name = "Yameen";
        WiproTopper.age = 24;

        System.out.println(WiproTopper.name + ", and age is "+ WiproTopper.age);

        WiproTopper sahil = new WiproTopper();

        sahil.name = "Sahil";
        sahil.age = 25;

        System.out.println(WiproTopper.name + ", and age is "+ WiproTopper.age);
        System.out.println(sahil.name + ", and age is "+ sahil.age);

        System.gc();

        System.out.println(WiproTopper.name + ", and age is "+ WiproTopper.age);
        System.out.println(sahil.name + ", and age is "+ sahil.age);

        System.out.println(Runtime.getRuntime().totalMemory());

        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();     // in bytes
        long freeMemory = runtime.freeMemory();       // in bytes
        long usedMemory = totalMemory - freeMemory;

        List<Integer> list = new ArrayList<>();

        int a =0;
        while(a<=1000000){
            list.add(a++);
        }
//        for(int x: list){
//            System.out.println(x+ "  ");
//        }
        System.out.println();
        System.out.println("Total Memory (MB): " + (totalMemory / (1024 * 1024)));
        System.out.println("Free Memory  (MB): " + (freeMemory / (1024 * 1024)));
        System.out.println("Used Memory  (MB): " + (usedMemory / (1024 * 1024)));
    }

}



