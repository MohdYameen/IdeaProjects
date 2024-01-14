package com.yameen;

public class WithoutSemicolon {
    public static void main(String ... args){
        if(System.out.printf("Yameen") ==  null) {

        }
        //Int to binary => count coolness which is denoted by occurrence of '101' in its binary equivalent.
        int count = 0;
        for(int i =2;i<=48;i++) {
           String s = Integer.toBinaryString(i);
            //System.out.println(s);
            for(int j =0; j<s.length()-2; j++){
                if(s.charAt(j) == '1'){
                    if(s.charAt(j+1) == '0' && s.charAt(j+2) == '1'){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
