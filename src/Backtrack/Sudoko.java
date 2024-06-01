package Backtrack;

public class Sudoko {
    static void printSuduko(int [][] sudoko){
        for(int[] n: sudoko){
            for(int k : n) System.out.print(k+" ");
            System.out.println();
        }
    }

    static boolean isSafe(int [][] sudoko, int row, int col, int digit){
        //column
        for(int i=0; i<=8; i++){
            if(sudoko[i][col] == digit) return false;
        }

        //row
        for(int j=0; j<=8; j++){
            if(sudoko[row][j] == digit) return false;
        }

        //grid
        int sRow = (row/3)*3;
        int sCol = (col/3)*3;
        for(int i = sRow; i<sRow+3; i++){
            for (int j = sCol; j<sCol+3; j++){
                if(sudoko[i][j] == digit) return false;
            }
        }
        return true;
    }

    static boolean sudokoSolver(int [][] sudoko, int row, int col){

        ///base condition
        if(row == 9 && col == 0) return true;

        //recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoko[row][col] != 0) return sudokoSolver(sudoko, nextRow, nextCol);

        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoko, row, col, digit)){
                sudoko[row][col]=digit;
                if(sudokoSolver(sudoko, nextRow, nextCol)) return true;
                sudoko[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] sudoko = {{0,0,8,0,0,0,0,0,0},
                {4,9,0,1,5,7,0,0,2},
                {0,0,3,0,0,4,1,9,0},
                {1,8,5,0,6,0,0,2,0},
                {0,0,0,0,2,0,0,6,0},
                {9,6,0,4,0,5,3,0,0},
                {0,3,0,0,7,2,0,0,4},
                {0,4,9,0,3,0,0,5,7},
                {8,2,7,0,0,9,0,1,3}};

        printSuduko(sudoko);
        System.out.println();
        if(sudokoSolver(sudoko, 0,0)){
            System.out.println("Solution Exists");
            printSuduko(sudoko);
        } else System.out.println("Solution does not exist");
    }
}
