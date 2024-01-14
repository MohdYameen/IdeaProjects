package com.yameen;

import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> ar = new ArrayList<>();

    void add(int data){
        ar.add(data);
    }
    void remove(){
        ar.remove(0);
    }
    void peek(){
        if(ar.isEmpty()){
            System.out.println("It is empty");
        }
        else {
            System.out.println(ar.get(0));
        }
    }

    public static void main(String ... args){
        Queue mq = new Queue();
        mq.add(5);
        mq.peek();
        mq.remove();
        mq.peek();
    }
}
