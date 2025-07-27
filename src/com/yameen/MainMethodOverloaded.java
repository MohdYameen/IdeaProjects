package com.yameen;

public class MainMethodOverloaded {

    public static void main(String ... args) {
        System.out.println("Main with String[] args"+ args.toString());
        main("Hello");
        main(12);
    }

    public static void main(String args) {
        System.out.println("Main with single String arg: " + args);
    }

    public static void main(int args) {
        System.out.println("Main with int arg: " + args);
    }
}
