package com.examples;

/*
Reflection:  used rarely
    examine classes, methods, fields, interfaces at runtime and also possible to change the behaviour of class too.
    example:
        what all methods present in class?
        fields?
        return type of methods
        modifier of class
        interfaces implemented?
        change the value of public and private fields of th class

How to do Reflection?  many-many .get methods available
    1. Create object of Class: 3 ways
            Class.forName("Bird), Class birdClass = Bird.class, birdObj.getClass()
    2. Create object of Object :
            Object birdObj = birdClass.newInstance();
            If constructor is private, create cont using birdClass.getDeclaredContructor(); cont.setAccessible(true);
    3. Create method :
            Method method = birdClass.getMethod("methodName");
    4. Invoke method: only methods can be invoked
            method.invoke(birdObj); or method.invoke(obj2, "Yameen"), if method is expecting some input


class Class : during class loading by JVM, JVM create object of Class
    instance of this class represent Class at runtime, JVM creates it
    this class has metadata of our classes

 */

//import com.yameen.MyClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyReflection {

    public static void main(String[] args) throws Exception{

//
//        Class birdClass1 = Class.forName("Bird");
//        Class birdClass2 = Bird.class;
//
//        Bird birdObj = new Bird();
//        Class birdClass3 = birdObj.getClass();

        // Reflection, call method using reflection in Java
        Class myClass = Bird.class;
        Object obj = myClass.newInstance();
        Method method = myClass.getMethod("printFly");
        System.out.println(method.invoke(obj));

        Method method2 = myClass.getMethod("printLifespan", int.class);
        System.out.println(method2.invoke(obj, 12));

        Method [] methods = myClass.getDeclaredMethods();

        // print all methods
        for(Method m : methods){
            System.out.println("Method name : "+m.getName()+ " and its return type is "+ m.getReturnType());
        }

        Class eagleClass = Eagle.class;


        Constructor cont = eagleClass.getDeclaredConstructor();
        cont.setAccessible(true);

//        Eagle e = (Eagle) cont.newInstance();
//        e.fly();

        Object eagleObj = cont.newInstance();
        Method eagleMethod = eagleClass.getMethod("fly");
        eagleMethod.invoke(eagleObj);


//        Constructor[] constructorsList = eagleClass.getDeclaredConstructors();
//        for (Constructor constructor : constructorsList){
//            System.out.println("modifier : "+ Modifier.toString(constructor.getModifiers()));
//            constructor.setAccessible(true);
//
//            Eagle eagle = (Eagle) constructor.newInstance();
//            eagle.fly();
//        }

    }
}


class Bird{

    public String breed;
    public boolean canFly;

    public String printFly(){
        return "Flying";
    }

    public int printLifespan(int a){
        return a;
    }

//    public Bird(String breed, boolean canFly) {
//        this.breed = breed;
//        this.canFly = canFly;
//    }

}

class Eagle{
    private Eagle(){

    }
    public void fly(){
        System.out.println("Eagle is flying");
    }
}