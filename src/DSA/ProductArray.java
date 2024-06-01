package DSA;

public class ProductArray {

    static void product(int [] arr){
        int n = arr.length;
        if(n == 0) System.out.println(0);

        int [] left = new int[n];
        int [] right = new int[n];

        left[0]=1;
        right[n-1]=1;

        //fill left array
        for(int i=1;i<n;i++){
            left[i] = left[i-1]*arr[i-1];
        }

        //fill right array
        for(int j=n-2;j>=0;j--){
            right[j] = arr[j+1]*right[j+1];
        }

        for(int i=0;i<n;i++){
            System.out.print(left[i]*right[i]+" ");
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        product(arr);
    }
}
