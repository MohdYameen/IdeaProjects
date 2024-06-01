package com.ClassLPU;
//interface

interface iA {      //functional interface, as it has only one abstract method.
    void message(); //by default public and abstract(can never be static).
}
interface iB {          //functional interface
    String getMessage();
}
interface iC {      //functional interface
    void myMessage(String str);
}
interface sampleNonFunctionalInterface{     //non-functional interface, as it has more than one abstract method
    void show();
    void message();
}
interface iD{
    String customMessage(String s);
}
//one way(using class and interface)
class A implements iA {
    public void message(){
        System.out.println("Hello : This is message");
    }
}
class Main{
    public static void main(String ... args){
        A myA = new A();
        myA.message();
        //second way (anonymous class).
        iA objectInterface = new iA(){
            public void message(){
                System.out.println("Interface printed");
            }
        };
        objectInterface.message();

        //third way (lambda)
        iA objectInterface2 = () -> System.out.println("Third way to print interface. ");

        objectInterface2.message();
        iB ob3 = ()->"Lambda functional interface";
        String s = ob3.getMessage();
        System.out.println(ob3.getMessage());

        iB ob4 = () ->{String s1 = "Another way"; return s1;};
        String s1 = ob4.getMessage();
        System.out.println(s1);

        iC ob5 = (n) -> System.out.println(n);

        ob5.myMessage("iC interface with one method with argument");
        iD ob6 = (k) -> "MY name is " +k;
        //ob6.customMessage("My custom message");
        System.out.println(ob6.customMessage("Yameen"));


    }
}
