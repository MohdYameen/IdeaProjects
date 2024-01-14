package com.yameen;

public class SpecialCharacter {
    public static void main(String ... args){
        String str = "qwerASD 2";
        Boolean b = false;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i) > (char ) 64 && str.charAt(i) < (char ) 91 || str.charAt(i) > (char ) 96 && str.charAt(i) < (char ) 123 || str.charAt(i) > (char ) 47 && str.charAt(i) < (char ) 58){

            }
            else{
                b = true;
            }
        }

        if(b){
            System.out.println("Special character found");
        }
        else{
            System.out.println("Not found");
        }
    }

}
