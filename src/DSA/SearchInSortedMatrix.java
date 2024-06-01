package DSA;

public class SearchInSortedMatrix {

    public static boolean searchInMatrix(int [][] matrix, int key){

        // using top-right element
//        int row=0; int column = matrix[0].length-1;
//
//        while(row < matrix.length && column >= 0){
//            if(matrix[row][column] == key){
//                System.out.println("Key found at ("+row+ ", "+column+").");
//                return true;
//            } else if (key < matrix[row][column]) {
//                column--;
//            } else {
//                row++;
//            }
//        }

        //using bottom-left element
        int row = matrix.length-1, column = 0;

        while(row >=0 && column < matrix[0].length-1){
            if(matrix[row][column] == key){
                System.out.println("Key found at ("+row+ ", "+column+").");
                return true;
            } else if (key < matrix[row][column]) {
                row--;
            } else {
                column++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        int [][] matrix = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key = 39;



//        for (int[] i : matrix) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(i[j] + "    ");
//            }
//            System.out.println();
//        }
        searchInMatrix(matrix, key);
    }
}
