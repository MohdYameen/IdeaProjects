package com.ClassLPU;

import java.util.ArrayList;

public class LambdaIterator {
    public static void main(String ... args){
        ArrayList<String> l = new ArrayList<String>();

        l.add("Blue");
        l.add("Black");
        l.add("Red");
        l.add("Yellow");
        l.add("Green");
        l.add("White");
        System.out.println("Lambda Iteration : ");
        l.forEach( (str) -> System.out.print(str +" "));        //lambda iterator.


    }
}
