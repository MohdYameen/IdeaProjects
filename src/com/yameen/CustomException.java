package com.yameen;

// checked custom exception
class MyException extends Exception{
    public MyException(String s){
        super(s);
    }
}


// unchecked expection
class DivideByZeroException extends RuntimeException{
    public DivideByZeroException(String s){
        super(s);
    }
}

public class CustomException {

    public static void divide(int a, int b) throws DivideByZeroException{
        if(b==0) throw  new DivideByZeroException("Division by 0 is not allowed");
        System.out.println("Result : "+a/b);
    }

    public static void main(String[] args) {
        try{
            throw  new MyException("New Custom Exception");
        } catch (MyException e){
            System.out.println("Caught");
            System.out.println(e.getMessage());
        }


        try{
            divide(10,0);
        }catch (DivideByZeroException e){
            System.out.println("Exception Caught : "+ e.getMessage());
        }
    }


}
