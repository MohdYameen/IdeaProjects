package com.examples;


/* ******************STREAM******************

    Stream is like a pipeline through which entire collections entry pass.
    Then it does multiple operations on in while passing though the pipeline.

Create:
    Collections     : list.stream()
    Array           : Arrays.stream(arr)
    Static          : Stream.of(1000,2000,3000)
    String          : str.chars()   //intStream
    StreamBuilder   : StreamBuilder builder = new StreamBuilder; -> builder.add(1000).add(2000);

Intermediate Operations:
    filter()        : filter each element, accept one input, Predicate. If true, add it to next stream .filet(n->n.length() >3)
    map()           : transform each element (functional interface) : .map(s -> s.toLowercase());
    flatMap()       : flatten list of list, complex collections : .flatMap(List<String> sentence -> sentence.stream());
    distinct()      : remove duplicates
    sorted          : return sorted stream : .sorted(Comparator.reverseOrder());
    peek()          : let you see immediate result of stream, not return anything
    limit()         : set max size
    skip()          : skip first n elements
    mapToInt()      : help to work with primitive data type

Terminal Operations :
    forEach()       :
    toArray()       :
    reduce()        :
    collect()       :
    min()           :
    max()           :
    count()         :
    anyMatch()      :
    findFirst()     :


Sequential Stream   :
    By default, streams are sequential
    processing happens in a single thread
    order is preserved
    safer for small datasets or when order matters

Parallel Stream     :
    Explicitly use parallelStream()
    Works concurrently, make use of ForkJoinPool internally
    Processing happens in multiple thread
    order may not be preserved
    overhead of thread splitting -> not always faster for small data sets
    internally uses

 */

import javafx.scene.paint.PhongMaterial;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyStream {

    public static void main(String[] args) {

        String str = "yameenu";

        //filter vowels from string using stream
        String vowels = str.chars()
                .mapToObj(c -> (char)c)
                .filter(c-> (c=='a' || c=='e'||c=='i' ||c=='o'||c=='u'))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(str + " to " + vowels);

        // count occurance of each character
        Map<Character, Long> hMap = str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(hMap);


        // to filter second greater even number
        int [] array = {1,2,2,3,4,5,6,7,8,9};
        int solution = Arrays.stream(array)
                .filter(n -> n%2 == 0)
                .skip(1)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .findFirst()
                .orElse(-1);

//        System.out.println("Second larget even number in array is "+ solution);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Yameen");

//        names.stream()
//                .forEach(n -> {
//                    System.out.println(Thread.currentThread().getName()+ " : "+n);
//                });

        System.out.println("Parallel Stream");

        names.parallelStream()
                .forEach(name -> {
                    System.out.println(Thread.currentThread().getName() + ": "+ name);
                });




    }
}
