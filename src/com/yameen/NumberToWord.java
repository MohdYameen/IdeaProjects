package com.yameen;

public class NumberToWord {

    private static final String[] belowTwenty = {
            "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    public static String numberToWords(int number){

        if(number == 0) return "Zero";

        int i = 0;
        String words = "";

        while(number > 0){
            if(number % 1000 != 0){
                words = helper(number % 1000) + thousands[i] +" "+ words;
            }
            number/=1000;
            i++;
        }

        return words;

    }

    public static String helper(int number){
        if(number==0) return "";
        else if (number < 20) return belowTwenty[number]+" ";
        else if(number < 100) return tens[number/10]+ " "+ helper(number % 10);
        else return belowTwenty[number/100] +" Hunderd "+ helper(number%100);
    }

    public static void main(String[] args) {
        int number = 4;
        System.out.println("Number: " + number);
        System.out.println("In words: " + numberToWords(number));
    }
}
