package com;

//create a method which takes in 2 parameter size and int array
//and print int array elements without using loop, stream, iterator


//input string in 12 hour format, returns output time in 24 hour format string like for input - hh:mm:ss AM
//or hh:mm:ss   PM, output - should be hh:mm:yy in 24 hour format
//ex. 8:05:45PM should give output 20:05:45 and add unit test for the same

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestDummy {

    public static int printArrayWithoutLoop(int arr [], int size){
        if(size==0) return -1;
        System.out.print(arr[size-1]+" ");
        return printArrayWithoutLoop(arr, size-1);
    }

    public static int secondHigest(int arr []){
        int highest = Integer.MIN_VALUE;
        int secondHigest = 0;
        for(int i: arr){
            if(highest <= i){
                secondHigest= highest;
                highest= i;
            }
        }
        return secondHigest;
    }

    public static String convertTwelveHourToTwentyHour(String time12Hour){
        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
        try{
            Date date = inputFormat.parse(time12Hour);
            return outputFormat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static int maxProduct(int [] arr){
        int result = arr[0];

        for(int i=0; i<arr.length;i++){
            int mul = 1;
            for(int j=i;j<arr.length;j++){
                mul *= arr[j];
                result = Math.max(result, mul);
            }
        }
        return result;
    }

    public static int [] flatten2DArray(int [][] arr){
        List<Integer> list = new ArrayList<>();

        for(int [] a:arr){
            for(int b:a){
                list.add(b);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {

        int [] arr = {1,0,3,4,5};
//        System.out.println(Arrays.toString(arr));
        int[][] irregularArray = {
                {1, 2},
                {3, 4, 5},
                {6}
        };

        int [] l =Arrays.stream(irregularArray).flatMapToInt(Arrays::stream).toArray();

        String input = "Java is great and Java is powerful and Java is popular";

        String [] words = input.toLowerCase().split("\\W+");

        System.out.println(Arrays.toString(words));

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String word: words){
            hashMap.put(word, hashMap.getOrDefault(word,0)+1);
        }

        System.out.println("Dup words");

        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            if(entry.getValue()> 1){
                System.out.println(entry.getKey()+ " : "+entry.getValue());
            }
        }

        System.out.println("unique words");
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            if(entry.getValue()== 1){
                System.out.println(entry.getKey());
            }
        }

//        System.out.println(Arrays.toString(irregularArray[0]));

        System.out.println("End");

//        int [] l = Arrays.stream(arr).toArray();

        int flat[] = flatten2DArray(irregularArray);
        System.out.println(Arrays.toString(flat));

//        printArrayWithoutLoop(arr,5);

        LocalTime time = LocalTime.of(8, 30, 30);

//        convertTwelveHourToTwentyHour(time);
//        System.out.println(secondHigest(arr));

        String time12h = "8:00:00 PM";
        String time24h = convertTwelveHourToTwentyHour(time12h);
        System.out.println("12-hour format: " + time12h);
        System.out.println("24-hour format: " + time24h);

        System.out.println(maxProduct(arr));

        Object [] arr1 = {1,2,new Object[]{3,4,  new Object[]{5},6, 7}};

        System.out.println("Final output");
        List<Object> newList = new ArrayList<>();
        flatten(arr1, newList);
        System.out.println(newList.toString());
        for(Object i:newList){
            System.out.print(i+" ");
        }


    }

    public static void flatten(Object[] arr, List<Object> list){
        for (Object element: arr){
            if(element instanceof Object []){
                flatten((Object []) element, list);
            } else list.add(element);
        }
    }
}
