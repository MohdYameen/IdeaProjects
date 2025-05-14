package DSA;

import java.util.ArrayList;

public class SpiralMatrix {

    public static void printSpiralMatrix(int [][] matrix){
        int startRow =  0;
        int startColumn = 0;
        int endRow = matrix.length-1;
        int endColumn = matrix[0].length-1;
        int iC = 1;
        int iR = 1;

        int itr = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(startRow <= endRow && startColumn <= endColumn){


            //top
            for(int j=startColumn; j<= endColumn;j++){
                list.add(matrix[startRow][j]);

//                System.out.print(matrix[startRow][j]+" ");
            }
            for (int x:list){
                System.out.print(x+" ");
            }
            System.out.println();
            System.out.println(itr+"   top...................");



            //right
            for(int i = startRow+1;i<=endRow; i++){
                list.add(matrix[i][endColumn]);
//                System.out.print(matrix[i][endColumn]+" ");
            }
            for (int x:list){
                System.out.print(x+" ");
            }
            System.out.println();
            System.out.println(itr+"    right...................");




            //bottom
            if(startRow<= endRow){
                for(int j=endColumn-1;j>startColumn;j--){
                    list.add(matrix[endRow][j]);
//                System.out.print(matrix[endRow][j]+" ");
                }
            }
            for (int x:list){
                System.out.print(x+" ");
            }
            System.out.println();
            System.out.println(itr+"    bottom...................");




            //left
            if(startColumn <= endColumn){
                for(int i=endRow-1;i>=startRow+1;i--){
                    list.add(matrix[i][startColumn]);
//                System.out.print(matrix[i][startColumn]+" ");
                }
            }

            for (int x:list){
                System.out.print(x+" ");
            }
            System.out.println();
            System.out.println(itr+"    left...................");
            startColumn++;
            startRow++;
            endRow--;
            endColumn--;
            itr++;
        }

//        for (int x:list){
//            System.out.print(x+" ");
//        }
    }

    public static void printSpiral(int [][] matrix){
        ArrayList<Integer> list =  new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Top row
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Bottom row
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Left column
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        for(int x:list){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int [][] matrix = new int[3][4];
        //int rows = 6, column = 6;
        int sum =1;
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) matrix[i][j] = sum++;
        }
        //to print matrix
        for (int[] i : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(i[j] + "    ");
            }
            System.out.println();
        }
        System.out.println();
        printSpiral(matrix);
    }
}
