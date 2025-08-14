package com.oas;

//class A{
//    int add(int i, int j){
//        return i+j;
//    }
//}

public class OA1 {

//    static String str;
//
//    public void OA1(){
//        System.out.println("In const");
//        str = "Hello";
//    }

    public static void main(String[] args) {

//        short s = 9;
//        System.out.println(add(s, 6));

//        OA1 a = new OA1();
//        System.out.println(str);
//        System.out.println("QQQ");

        try{
            badMethod();
            System.out.println("A");
        }
        catch (Exception ex){
            System.out.println("B");
        }
        finally {
            System.out.println("C");
        }
        System.out.println("D");
    }

    public static void badMethod(){

    }
}
