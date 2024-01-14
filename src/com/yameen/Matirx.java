package com.yameen;

public class Matirx {
    public static void main(String ... args){
        int a[][] = {{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};
        for(int i =0;i<a.length;i++){
            System.out.print("|");
            for(int j=0;j<a[i].length;j++){
                System.out.print(" "+a[i][j] + " |" );
            }
            System.out.println();
        }
        System.out.println();
        int trans [][] = new int[a.length][a[0].length];

        for(int i =0;i<trans.length; i++){
            System.out.print("|");
            for(int j=0;j<trans[i].length;j++){
                trans[i][j] = a[j][i];
                System.out.print(" "+trans[i][j] + " |" );
            }
            System.out.println();
        }
        int lw[][] = new int[4][4];
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i==j){
                    lw[i][j] = 1;
                }
                else
                    lw[i][j] = 0;
            }
        }
        System.out.println();
        for(int i =0;i<trans.length; i++){
            System.out.print("|");
            for(int j=0;j<trans[i].length;j++){
                System.out.print(" "+lw[i][j] + " |" );
            }
            System.out.println();
        }



    }

}
