package com.examples;

import lombok.*;

/*

Project Lombok :
    java library help to reduce boilerplate code using annotations
    during compilation, it process the annotation and inject code into our java classes
    started from java6
    dep : org.project.lombok

10 frequently used features:
    1. val and var : instead of writing the type, used for local variable
            val : local variable made final
            var : local vairable not final

    2. @NonNull : generates a null check statement

    3. Getters and Setters : by default public, but can be controlled.
            can be used with class, will be applied to all non-static fields
            @Getter(AccessLevel.PRIVATE) and same for setter

    4. @ToString : used with class definition, return : class name + field name
                .Exclude :  if you don't want
                .Include : to used specific when @ToString(onlyExplicitlyIncluded =  true)

    5. @NoArgsConstructor : create no arg cont.
       @AllArgsContructor : create all arg cont.
       @RequiredArgsConstructor : specific arg cont

    6. @EqualsAndHashCode : non static and non transient fields, used in hachcode and equals methods
            .Exclude

    7. @Data : toString, hashcode(), equals(), getter(), setter(), req Args constructor

    8. @Value : Immutable version of @Data, all fields are made final, all args constructor

    9. @Builder :  helps to create immutable and part by part
                   create a builder class for you, follows builder design pattern

    10. @Cleanup : ensure resource is automatically cleaned up before execution path exits the current scope

 */

public class ProjectLombok {

    public static void printName(@NonNull String name){
        System.out.println(name);
    }

    public static void main(String[] args) {
        val temp = "Hello";

//        temp = "qwerty";  // not possible for val
        var a = 10;
        a=11;
        System.out.println(a);
        System.out.println(temp);

        printName("");

        printName("Yameen");
    }
}

@AllArgsConstructor
class LomEmp{
    @Getter @Setter
    String name;
}
