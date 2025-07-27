package com.yameen;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Newww {


    public static void some(Integer s){
        System.out.println("String");
    }
    public static void some(Object o){
        System.out.println("Object");
    }
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        //some(new Object());
        System.out.println("new");


        Class oldclassReflection = Old.class;
        System.out.println(oldclassReflection);


        Old oldObj = new Old();

        System.out.println(oldclassReflection.getName());

//        Method [] methods = oldclassReflection.getMethods(); // this will get all public methods of this class plus its parent class which is Object class
        Method [] methods = oldclassReflection.getDeclaredMethods(); // this will get all methods of Old class, public/private all
        int i=1;
        for(Method method: methods){
            System.out.println(i++);
            System.out.println("Method name : "+method.getName());
            System.out.println("Return type : "+method.getReturnType());
            System.out.println("Declaring Class type : "+method.getDeclaringClass());

        }

        Object oldObject = oldclassReflection.newInstance();

        Old old = new Old();

        Method setName = oldclassReflection.getMethod("setName", String.class);

        Field yamAge = oldclassReflection.getDeclaredField("age");

        yamAge.set(old, 15);


        setName.invoke(oldObject,"Yameen");
        System.out.println(old.age);

    }
}

class Old{
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int age;
}



