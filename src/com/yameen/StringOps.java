package com.yameen;

public class StringOps {
    public static void main(String ... args){
        String s = "qwertyudfgpoip";
        String s1 = s.substring(2,6);
        String s3 = s1.concat("__Works");
        s.concat("QWERT");
        String s4 = s.replace('q','m');
        String vowels ="";
        String conso = "";
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == 'a' ||s.charAt(i) == 'e' ||s.charAt(i) == 'i' ||s.charAt(i) == 'o' ||s.charAt(i) == 'u'){
                vowels+=s.charAt(i);
            }
            else
                conso+=s.charAt(i);

        }
        System.out.println(s);
        System.out.println(vowels +" "+conso);
        System.out.println(s1 + " " + s3);
        System.out.println(s4);
        System.out.println(s.equals(s1));
    }

}
