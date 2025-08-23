package com.examples;

/*
Annotation: denoted with @ like @Override
    kind of metadata to java code
    access annotations using reflection internally
    optional usage
    we can use this metadata info at runtime and add certain logic in our code, if required
    can be applied anywhere

Types : 2
    1. Pre Defined : 2 Types : Used on Java Code and Used on Annotations (Meta-Annotations)
    2. Custom/User Defined

    Annotations used on Java Code:
        @Deprecated : mark old, outdated class, method or fields (no funrther improvements on this)
        @Override   : info to compile, check its parent and same method should present in parent, used used over methods
        @SupressWarning("all" or "deprecation") : ignore warnings like usage of @Deprecated, unused
        @FunctionalInterface : only one method interface, can be used with lambda
        @SafeVarargs : supress "heap pollution warning", ( ... in main method is varargs)

    Annotation used on Annotation: ElementType on these Annotation_Type
        @Target : restrict where to use annotation, ElementType:
        @Retention : how it stored in java, .SOURCE(not come to .class file), .CLASS(ingoned at runtime), .RUNTIME(can be used at runtime)
        @Documented: by default, annotations are ignored during javadoc, with this, annotations are included too.
        @Inherited : by default, annotations applied on parent classes are not inherited by child classed, with this, child class should be able to access it
        @Repeatable : instead of array of any annotation or anno that you want to repeat. It will require a container

Heap pollution :
    Object of one type storing reference of another type Object, possible with varargs


 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

//@AnnotationOne(print = "hello yameen")
public class MyAnnotations {

    @AnnotationOne(print = "hello yameen")
    public void fly(){
        System.out.println("flymethod");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        MyAnnotations myAnnotations = new MyAnnotations();
        myAnnotations.fly();

        Method method = myAnnotations.getClass().getMethod("fly");

        if(method.isAnnotationPresent(AnnotationOne.class)){
            AnnotationOne annotationOne = method.getAnnotation(AnnotationOne.class);
            System.out.println("Annotation print : "+annotationOne.print());

        }
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface AnnotationOne{

    String print() default "hello there";

}