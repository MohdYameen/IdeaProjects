package DSA;

public class SpiralMatrix {

    public static void printSpiralMatrix(int [][] matrix){
        int startRow =  0;
        int startColumn = 0;
        int endRow = matrix.length-1;
        int endColumn = matrix[0].length-1;

        while(startRow <= endRow && startColumn <= endColumn){
            //top
            for(int j=startColumn; j<= endColumn;j++){
                System.out.print(matrix[startRow][j]+" ");
            }
            //right
            for(int i = startRow+1;i<=endRow; i++){
                System.out.print(matrix[i][endColumn]+" ");
            }
            //bottom
            for(int j=endColumn-1;j>=startColumn;j--){
                System.out.print(matrix[endRow][j]+" ");
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                System.out.print(matrix[i][startColumn]+" ");
            }
            startColumn++;
            startRow++;
            endRow--;
            endColumn--;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int [][] matrix = new int[4][6];
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
        printSpiralMatrix(matrix);
    }
}
