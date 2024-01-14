package com.yameen;

import java.util.ArrayList;

public class Palindrome {
    public static void main(String ... args){

        /*
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String rev = "";
        for(int i = s.length() -1;i>=0;i--){
            rev+=s.charAt(i);
        }
        System.out.println(s);System.out.println(rev);
        if(s.equals(rev)){
            System.out.println("Palindrome");
        }
        else
            System.out.println("Not Palindrome");

         */
        int min = 50, max = 78;
        int amount = 12;
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i = min;i<=max;i++){
            if(isPalindrome(i)) {
                ar.add(i);
            }
        }
        int count=0;
        for(int i =0;i<ar.size() -1;i++){
            for(int j = i+1;j<ar.size();j++){
                if(ar.get(j) - ar.get(i) <= amount )
                    count++;
            }
        }
        System.out.println(count);
        /*
        //Date And Time
        LocalDateTime d = LocalDateTime.now();
        System.out.println(d);
        DateTimeFormatter nDF = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        String strDateTime = d.format(nDF);
        System.out.println(strDateTime);\

         */
        int aq = 45554;
        System.out.println(isIntPalindrome(aq));
        for(int i =0;i<50;i++){
            if(isIntPalindrome(i))
                System.out.print(i + ", ");
        }
        System.out.println();
        int a=5,b=6;
        int c = a^b;
        switch (c){
            case 0 :
                System.out.println("eqauls");
        }

    }
    public static boolean isPalindrome(int n){
        String s = Integer.toString(n);
        String rev = "";
        for(int i = s.length() - 1;i>=0;i--)
            rev+=s.charAt(i);

        if(s.equals(rev))
            return true;
        else
            return false;

    }
    public static boolean isIntPalindrome(int n){
        int temp =n;
        int sum=0;
        while(temp>0){
           int r =temp%10;
            sum =(sum*10)+r;
            temp=temp/10;
        }
        if(sum==n)
            return true;
        else
            return false;
    }
}
