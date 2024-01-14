package com.yameen;

import java.util.*;

public class HashMapTable {

    public static void main(String [] args){
        HashMap<Integer, String> hMap = new HashMap<>();
        Hashtable<Integer, String> hTable = new Hashtable<>();

        hMap.put(1,"A");
        hMap.put(2,"b");
        hMap.put(3,"c");
        hMap.put(4,"A");
        hMap.put(5,"");
        hMap.put(1,"f");

        Set set = hMap.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry mEntry = (Map.Entry)it.next();
            System.out.println(mEntry.getKey()+ ", "+mEntry.getValue());
        }

        hTable.put(1,"A");
        hTable.put(2,"b");
        hTable.put(3,"c");
        hTable.put(4,"c");
        hTable.put(1,"e");

      /*  Set<Integer> st = new Set<Integer>(){

            @Override
            public boolean add(Integer integer) {
                return false;
            }

        };
        st.add(2);
        st.add(5);
        st.add(2);
        System.out.println(st.iterator());*/

        System.out.println(hMap.get(1));
        System.out.println(hTable.get(1));

    }
}
