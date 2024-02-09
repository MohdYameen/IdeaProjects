package DSA;

public class TwoDArray {

    public static boolean searchInMatrix(int matrix[][], int key){

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){
                //System.out.print(matrix[i][j]+"    ");
                if(key == matrix[i][j]){
                    System.out.println("Key "+key+" found at "+i+", "+j);
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {

        int [][] matrix = new int[4][3];
        int rows = 4, column = 3;
        int sum =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++) matrix[i][j] = sum++;
        }

        for(int i=0;i<rows;i++){

            for(int j=0;j<column;j++){
                System.out.print(matrix[i][j]+"    ");
            }
            System.out.println();
        }

        searchInMatrix(matrix,5);
        //System.out.println(searchInMatrix(matrix,51));


    }
}
