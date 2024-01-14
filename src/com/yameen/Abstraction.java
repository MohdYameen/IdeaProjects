package com.yameen;

abstract class Shape{
    public abstract void draw();
}
class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Circle. ");
    }
}
class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Triangle. ");
    }
}

public class Abstraction {
    public static void main(String ... args){
        Shape c = new Circle();
        c.draw();

        Shape t = new Triangle();
        t.draw();

        /*
        Abstraction is the feature of OOPS that hides the unnecessary detail but shows only the essential information.
        It is the implementation hiding.
        It focuses on external lookouts.
        It is process of gaining information.
        We use abstract classes and interfaces to hide code complexities.
         */


    }

}
