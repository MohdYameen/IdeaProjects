package Backtrack;

public class NQueens {

    static void printBoard(char [][]board) {
        System.out.println("_________________________");
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    static void nQueens(char [][]board, int row) {
        if (row == board.length) {
            count++;
            printBoard(board);
            return;
        }

        //column
        for (int j = 0; j < board[row].length; j++) {

            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = '-';
            }
        }
    }

    // this will print only one solution if possible.
    static boolean nQueensOneSolution(char [][]board, int row) {
        if (row == board.length) {
            count++;
            printBoard(board);
            return true;
        }
        //column
        for (int j = 0; j < board[row].length; j++) {

            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueensOneSolution(board, row + 1)) return true;
                board[row][j] = '-';
            }
        }
        return false;
    }

    static boolean isSafe(char [][]board, int row, int col){
        //vertical up i-1
        for(int i=row-1; i>=0;i--){
            if(board[i][col]=='Q') return false;
        }

        //top left diagonal -1, j-1
        for(int i=row-1, j=col-1; i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }

        //top right diagonal i-1, j+1
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }

    //to count the possible solutions
    static int count = 0;

    public static void main(String[] args) {
        int n = 3;
        char [][]board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='-';
            }
        }

        //printBoard(board);
        nQueens(board, 0);
        System.out.println(count);
        System.out.println(nQueensOneSolution(board, 0));
    }
}
