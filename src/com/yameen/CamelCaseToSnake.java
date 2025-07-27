package com.yameen;

import java.util.ArrayList;

public class CamelCaseToSnake {

    public static synchronized void convert(String s) throws InterruptedException {


        try{
            //        ArrayList<Character> list = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();


            if (s.length() == 0) return;

            for(int i=0;i<s.length();i++){
                char a = s.charAt(i);

                if(a >= 65 && a <= 90){
//                System.out.println("Capital letters : "+a);
//                System.out.println((char)(a+32));
//                list.add(a);
                    if(i != 0)
                        stringBuilder.append('_');
                    stringBuilder.append((char)(a+32));
                } else {
                    stringBuilder.append(s.charAt(i));
                }


            }

            System.out.println("Output::::: "+stringBuilder + " by thread: "+Thread.currentThread().getName());


            Thread.sleep(5000);
            //return stringBuilder.toString();
        } catch (Exception e){

        }

    }



    public static void main(String[] args) throws InterruptedException {
        String string = "myNameIsYameen";
        System.out.println(string);
        convert(string);
        Runnable task = () -> {
            try {
                convert("TestCamelCaseString");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(Thread.currentThread().getName() + ": " );
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        t1.start();
        t2.start();

    }
}
