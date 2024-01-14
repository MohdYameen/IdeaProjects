package com.yameen;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CountStringOccurance {
/*  //LONG METHOD
    static final int MAX_CHAR = 256;

    static void getOccurance(String str){
    int count[] = new int[MAX_CHAR];
    int len = str.length();
    for(int i =0;i<len;i++){
        count[str.charAt(i)]++;
    }

    char [] ch = new char[len];
    for(int i =0;i<len;i++){

        ch[i] = str.charAt(i);
        int find =0;
        for(int j=0;j<=i;j++){
            if(str.charAt(i) == ch[j]){
                find++;
            }
        }
        if(find ==1 ){
            System.out.println(str.charAt(i) +" : "+ count[str.charAt(i)]);
        }

    }


    }
     */


    public static void main(String ... args){
        String s = "hgcHgvkvTREW";
        String q = s.toLowerCase();
        Map<Character, Integer> mp = new HashMap<>();
        for(int i =0;i<q.length();i++){
            char c = q.charAt(i);
            if(mp.containsKey(c)){
                mp.put(c,mp.get(c) + 1);
            }
            else{
                mp.put(c,1);
            }

        }
        System.out.println(mp);
        mp.clear();
    }


}
