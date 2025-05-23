package com.yameen;

import java.util.Arrays;

public class Anagram {

    public static boolean areAnagram(String s1, String s2){

        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 != n2)
            return false;

        char[] str1 = new char[n1];
        char[] str2 = new char[n2];

        for(int i =0;i<n1;i++){
            str1[i]=s1.charAt(i);
            str2[i]=s2.charAt(i);
        }


        Arrays.sort(str1);
        Arrays.sort(str2);

        for(int i =0;i<n1;i++)
            if(str1[i]!=str2[i])
                return false;

        return true;
    }

    public static void main(String args[])
    {
        String s1 = "yameen";
        String s2 = "nyeema";

        if (areAnagram(s1,s2))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");
    }

}

