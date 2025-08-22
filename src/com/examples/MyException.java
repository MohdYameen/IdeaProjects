package com.examples;

/*

Checked Exception :
    Checked at compile time
    try-catch
    throws in method signature
    ex. FileNotFoundException, IOException, SQLException

Unchecked Exception :
    checked at runtime
    RuntimeException, subclass of Exception
    No need to declare method signature with throws
    ex. NullPointe, Arithmetic, ArrayIndexOutOfBound

 */

public class MyException {


    public static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("People under 18 are not allowed");
        }
        System.out.println("Welcome to Gold Gym");
    }

    public static void main(String[] args) {
        validateAge(13);
    }
}

class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String msg){
        super(msg);
    }

}


