package com.yameen;

public class OneITStringIntegerValue {
    public static void main(String ... args){
        String s = "24&6";
        double len = s.length();
        double sum =0;
        double a;
        for(int i =0;i<len;i++){
            if(s.charAt(i) <= 57 && s.charAt(i) >= 48){
                a  = s.charAt(i) - 48 ;
                sum+=a;
            }
        }
        double res = (sum + 0.500)/len;
        int out = (int)res;
        System.out.println(out);



    }

}
