package com.yameen;

import java.util.ArrayList;

public class MyHashMap {

    ArrayList<Integer> arKey = new ArrayList<>();
    ArrayList<String> arValue = new ArrayList<>();

    public void put(int key, String value){
        arKey.add(key);
        arValue.add(value);

    }
    public String getValue(int key){
        int index= -1;
        for(int i=0;i<arKey.size();i++){
            int temp = arKey.get(i);
            if(temp == key){
                index=i;
            }
        }
        if(index < 0)
            return "Key Not Found";
        else
            return arValue.get(index);
    }


    public static void main(String[] args) {
        MyHashMap mHP = new MyHashMap();
        mHP.put(1,"Yameen");
        mHP.put(2,"Sahil");
        String m = mHP.getValue(1);
        System.out.println(m);
    }
}
