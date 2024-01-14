package com.datastructure;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    List<Integer> l = new ArrayList<>();

    void add(int data){
        l.add(data);
    }
    int size(){
            return l.size();
    }
    void addTAtpos(int pos, int data){
        l.add(pos,data);
    }
    void show() {
        for(int i =0;i<l.size();i++)
            System.out.print(l.get(i)+ " ");
    }
    int sum(){
        int a = 0;
        for(int i = 0;i <l.size();i++)
            a+=l.get(i);
        return a;
    }



    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.add(12);
        ml.add(23);
        ml.show();
        System.out.println();
        ml.addTAtpos(0,45);
        ml.show();
        System.out.println();
        System.out.println(ml.size());
        System.out.println(ml.sum());
    }

}
