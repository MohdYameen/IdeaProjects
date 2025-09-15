package com.practice;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MyCheckedException extends Exception{
    public MyCheckedException(String msg){
        super(msg);
    }
}

class MyUncheckedException extends RuntimeException{
    public MyUncheckedException(String msg){
        super(msg);
    }
}


public class Newwwq {

    public static void throwChechedExp1(int age) throws MyCheckedException{
        if(age<18){
            throw new MyCheckedException("Not valid age, checked exception 1");
        }
        System.out.println("Age is : "+age);
    }

    public static void throwUncheckedExp(int age){
        if(age<18){
            throw new MyUncheckedException("Not valid age, unchecked exception");
        }
        System.out.println("Unchecked, Age is "+age);
    }

    public static void main(String[] args) {

        try{
            throwChechedExp1(22);
        } catch (MyCheckedException e){
            e.printStackTrace();

        }

        throwUncheckedExp(13);


//        String s = "yameenay";
//        s.concat("hi");
//        String r = new String("hello");
//        Map<String, Integer> hmap = new HashMap<>();
//
//        hmap.put(r, 2);
//        hmap.put(s, 1);
//        System.out.println(hmap.get(s));
//        System.out.println(hmap);
//        Map<Character, Long> cMap = s.chars()
//                .mapToObj(c-> (char)c)
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        System.out.println(cMap);




//        String a = s.chars()
//                .map(c -> (char) c)
//                .distinct()
//                .skip(1)
//                .findFirst()
//                .toString();
//
//        System.out.println(a);
//
//        Optional<Character> secondNonRep = s.chars()
//                .mapToObj(c-> (char) c);
//
//
//        Optional<Character> secondNonRepeating = IntStream.range(0, s.length())
//                .mapToObj(i -> s.charAt(i))
//                .filter(ch -> )



//        System.out.println(s);

//        List<String> arList = new ArrayList<>();
//        // left table: 10 matching rec, 5 Non Matching, 2 null
//
//        // right table : 10 matching rec, 5 Non Matching, 2 null
//
//        //find employee with hig in each dep
//        select empName, salary from employee e2 where e1.salary = (select max(e2.sal) from employee e2 where e1.dep = e2.dep);
//
//

    }
}
//
//
//class Employee{
//
//    private String name;
//    // sort on salary and then name
//
//}

