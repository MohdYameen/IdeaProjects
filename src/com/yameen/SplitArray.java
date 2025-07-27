package com.yameen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SplitArray {

    public static void split(int [] arr, int splitSize){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<arr.length;i=i+splitSize){
            int s=splitSize;
            int j=i;
            ArrayList<Integer> temp = new ArrayList<>();
            while(s>0 && j< arr.length){
                temp.add(arr[j++]);
                s--;
            }
            list.add(temp);
        }

        for(ArrayList<Integer> a : list){
            System.out.println(Arrays.toString(a.stream().mapToInt(Integer::intValue).toArray()));
        }
    }
    public static List<int []> newSplit(int [] arr, int splitSize){
        List<int []> list = new ArrayList<>();
        for(int i=0; i<arr.length; i=i+splitSize){
            int end = Math.min(arr.length, i+splitSize);
            list.add(Arrays.copyOfRange(arr, i, end));
        }
        return list;
    }


    public static void main(String[] args) {
//        int [] arr = {1,2,3,4,5,6,7,8,9};
//        String s= "";
//        int splitSize = 4;
//        split(arr, splitSize);

//        List<int []> out = newSplit(arr, splitSize);
//
//        for (int[] chunk : out) {
//            System.out.println(Arrays.toString(chunk));
//        }

        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        System.out.println(al);

        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
//            System.out.println("print : "+itr.next());
            if (itr.next() == 3) {
                al.remove(3);
            }
        }

        System.out.println(al);
    }
}
