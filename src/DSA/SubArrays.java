package DSA;

public class SubArrays {
    public static void printSubArrays(int []a){
        for (int i =0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                System.out.print("[");

                for (int k=i;k<=j;k++){
                    System.out.print(a[k]+" ");
                }
                System.out.print("]");
                System.out.println();
            }
            System.out.println();
        }
    }
    public static int printNumberOfSubArrays(int []a){
        return a.length*(a.length+1)/2;
    }
    public static void main(String[] args) {
        int []arr = {2,4,6,8,10};
        printSubArrays(arr);
        System.out.println(printNumberOfSubArrays(arr));

    }
}
