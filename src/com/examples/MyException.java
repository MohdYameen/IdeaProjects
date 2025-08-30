package com.examples;

/*


Exception : event that occurred in case something in our program goes wrong
            Exception, Message and Stack Trace

Error vs Exception: both are subclasses of Throwable
    Error : is a serious problem that program cannot recover from, caused by system level issues
            eg. OutOfMemory, StackOverflow
    Exceptions :

Object -> Throwable (2 child)
            1. Error        : JVM issues, can not be controlled by us. OutOfMemoryError and StackOverflowError (Runtime/Unchecked Exception)
                            : is a serious problem that program cannot recover from, caused by system level issues
                            eg. OutOfMemory, StackOverflow
            2. Exception    : represent recoverable condition in a program, can be caught and handled using try-catch block.
                            2 types, Checked(Compile time : IOEx, SQLEx,ClassNotFoundEx) and Unchecked(Runtime" ArithematicEx, NullPointerEx, ArrayIndexOutOfBondEx)

Checked Exception :
    Checked at compile time
    try-catch
    throws in method signature
    ex. FileNotFoundException, IOException, SQLException, ClassNotFoundException

Unchecked Exception :
    checked at runtime
    RuntimeException, subclass of Exception
    No need to declare method signature with throws
    ex. NullPointe, Arithmetic, ArrayIndexOutOfBound

Exception Handling : using try-catch

5 keywords:
    try     : to specify the code that can throw exception
    catch   : multiple catch(separate or single catch with pipe |)
              but only those present in downstream(called from try) method signature
    finally : always gets executed not matter if exception is caught or not , even after return
    throw   : explicitly throw an exception
    throws  : it just delicate the error handling to method's caller, caller have to use try and catch, in catch
              it can use Exception class that is being defined in method sign or its above hierarchy

Why need?
    It makes our code clean, by separating the error handling code from regular code
    It allow program to recover from error
    It allow us to add more info, which support debugging
    Improves security, by hiding  the sensitive info.
    But its little expensive, stack trace is huge

 */

public class MyException {


    // not handling exception but asking caller to handle it with throws
    public static void method1() throws ClassNotFoundException {
        throw new ClassNotFoundException("Class is not found");
    }

    // doing the exceptional handling within not making use of throws
    public static void method2(){
        try{
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void validateAge(int age) {
        if(age<18){
            throw new InvalidAgeException("People under 18 are not allowed");
        }
        System.out.println("Welcome to Gold Gym");
//        throw new InvalidAgeException("People under 18 are not allowed");
    }

    public static int divideEx(int a, int b){
        int val;
        try{
            val=a/b;
        } catch (ArithmeticException e){

            // this will allow our program to keep running
            val = -1;
        }
        return val;
    }

    public static void main(String[] args) {
        validateAge(23);


//        try{
//            method1();
//        } catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }

//        method1();    // will not work without try catch block or add throws in main method signature
//        method2();      // handling is already done, no need to do anything here

        System.out.println(divideEx(5,0));
    }
}

class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String msg){
        super(msg);
    }

}


