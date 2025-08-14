package com.yameen;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

class A{
    public static void m1(){
        System.out.println("A m1");
    }
}

class B extends A {
    public static void m1(){
        System.out.println("B m1");
    }
}

public class MySingleton {

    static int number = 5;

    public static int sum(int a, int b){
        return 1;
    }

//    private static MySingleton obj;
//
//    public MySingleton getInstance(){
//        if(obj == null){
//            obj = new MySingleton();
//        }
//        return obj;
//    }
//
//    private MySingleton(){
//
//    }




    public static void main(String[] args) {

        A a = new A();
        B b = new B();

        System.out.println("a ");
        a.m1();

        System.out.println("b ");
        b.m1();
        A ab = new B();
//        B ba = new A(); // not possible

        System.out.println("ab ");
        ab.m1();
        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(4);
        list.add(7);
        list.add(6);

        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list);

        Stream<Integer> stream = list.stream();

        Optional secondHigest =stream.sorted(Collections.reverseOrder()).skip(1).findFirst();

        System.out.println(secondHigest.get());

        Integer secInt = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("SecInt: "+secInt);
//
//        System.out.println("AAAA");
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1==i2);

//        BigInteger

        System.out.println(i3==i4);

        System.out.println(i3);
        System.out.println(i4);

        System.out.println(i3.equals(i4));



    }
}
