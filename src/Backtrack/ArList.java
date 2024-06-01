package Backtrack;

import java.util.ArrayList;

public class ArList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        matrix.add(arr);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);
        matrix.add(arr2);

        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(7);
        arr3.add(8);
        arr3.add(9);
        matrix.add(arr3);

        for (ArrayList<Integer> tempArr : matrix) {
            for (Integer integer : tempArr) System.out.print(integer + " ");
            System.out.println();
        }
    }
}
