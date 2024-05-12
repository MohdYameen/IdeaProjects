package com.ClassLPU;

import java.util.stream.Stream;
/*
Theory
Optional value : container object which may or may not contain a non-null value.

Bifunction      : different parameter types and return type can be different
BinaryOperator  : same types of parameters and return type os also same.
 */
public class StreamDemo2 {

    public static void main(String ... args){

        String months [] = {"jan", "feb", "march", "april","may","june"};
        Stream<String> strm = Stream.of(months);        //stream of string elements
        strm.filter(s -> s.startsWith("j")).
                findFirst().ifPresent(System.out::println);

    }
}
