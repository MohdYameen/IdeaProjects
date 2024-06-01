package Tree;

public class SlidingWindowMax {

    public static void main(String[] args) {
        //TODO fix this code
        int [] arr = {1,3,-1,-3,5,3,6,7,2,2,9};
        int k = 3;
        int [] res =  new int[arr.length - k +1];

        int rInx = 0;
        for(int i=0; i< arr.length-2; i++){
            int temp = Math.max(arr[i+2], Math.max(arr[i], arr[i+1]));
            res[rInx] = temp;
            rInx++;
        }

        for(int i:res){
            System.out.print(i+" ");
        }

    }
}
