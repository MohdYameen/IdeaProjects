package Backtrack;

public class GridWays {

    //i = rows, j = column, NxM: grid
    public static int printGridWays(int i, int j, int n, int m){

        if(i == n-1 && j == m-1) return 1;
            else if(i == n || j == m) return 0;
        return printGridWays(i+1, j, n, m) + printGridWays(i, j+1, n, m);
    }
    public static void main(String[] args) {
        int n = 3, m=3;
        int [][]gird = new int[n][m];
        System.out.println(printGridWays(0,0, n,m));

    }
}
