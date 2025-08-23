package com.examples;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
Functional Interface :
        interface with only 1 abstract method, it can have default method, can have static method or methods of object class like toString()

Lambda Expression : New way to implement functional interface, similar to anonymous but no need to give method signature
        Bird eagleObj = new Bird(() -> {
            sout();
        });

Anonymous class : class without name
        definition :
        Bird eagleObj = new Bird {
            public void canFly(String str){
                sout();
            }
        }

4 predefined java functional interface: (if our req are met by any of these, we can use)
    1. Consumer     : represent an operation, accept one single parameter and return no result, accept(T t)
    2. Supplier     : rep the supplier of the result, accept no input parameter and produces a result, T get()
    3. Function     : accept one argument and return a result. R apply(T t)
    4. Predicate    : accept one argument and return boolean. boolean test(T t)


 */
public class MyFunctionInterface {

    public static void main(String[] args) {

//        // Normal class
//        ClassOne classOne = new ClassOne();
//        classOne.print();
//
//        // Lambda Expression
//        InterfaceOne classTwo = () -> System.out.println("Directly from interface");
//        classTwo.print();
//
//        // Anonymous class, without name
//        InterfaceOne classThree = new ClassOne() {
//
//            @Override
//            public void print() {
//                System.out.println("Inside Anonymous Class");
//            }
//        };
//        classThree.print();

        // Consumer Interface
        Consumer<String> consumer = (String s) -> System.out.println("Consumer Interface");;
        consumer.accept("Yameen");

        Supplier<String> stringSupplier = () -> "Supplier Interface";
        System.out.println(stringSupplier.get());
//        stringSupplier.get();

        Function<Integer, String> integerStringFunction = (Integer i) -> i.toString() + " converted to string using Function Interface";
        System.out.println(integerStringFunction.apply(12));
//        integerStringFunction.apply(12);

        Predicate<Integer> integerPredicate = (Integer i)-> i%2==0;

        System.out.println("Number even number: "+integerPredicate.test(5)+", using Predicate Interface");

    }
}

class ClassOne implements InterfaceOne{

    @Override
    public void print() {
        System.out.println("Inside ClassOne Class");
    }
}

interface InterfaceOne {
    public void print();
}
