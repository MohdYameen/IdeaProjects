package DSA;

public class DiagonalSum {

    public static int diagonalSum(int [][]matrix){
        int sum=0;

        // O(n^2) not optimized
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                // for primary diagona;
//                if(i==j) sum +=matrix[i][j];
//                //for secondary diagonal
//                else if(i+j == matrix.length-1) sum+=matrix[i][j];
//            }
//        }


        //O(n)
        for(int i =0;i<matrix.length;i++){
            //for primary diagonal
            sum+=matrix[i][i];
            //for secondary diagonal
            if(i != matrix.length-i-1) sum+=matrix[i][matrix.length-i-1];
        }

        return sum;
    }

    public static void main(String[] args) {
        int [][] matrix = new int[5][5];
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

        System.out.println(diagonalSum(matrix));

    }

}
