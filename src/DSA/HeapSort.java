package DSA;

public class HeapSort {

    static void heapify(int [] arr, int n, int i){
        int largest = i;
        int left_child_node = 2*i +1;
        int right_child_node = 2*i +2;

        if(left_child_node < n && arr[left_child_node] > arr[largest]){
            largest = left_child_node;
        }
        if(right_child_node < n && arr[right_child_node] > arr[largest]){
            largest = right_child_node;
        }
        if(largest != i){
            int temp = arr[i];
            arr[i]=arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void heapsort(int [] arr){

        int len = arr.length;
//        for(int i = len/2 -1; i>=0;i--){
//            heapify(arr, len, i);
//        }
        //swap the elements and heapify
        for(int i = len-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void printArray(int [] arr){
      for (int i:arr){
          System.out.print(i+" ");
      }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] arr = {22,13,17,11,10,14,12,9,7};
//        ArrayList<Integer> arlist = new ArrayList<Integer>();
//        ArrayList<Integer> arlist2 = new ArrayList<Integer>();
//
//        arlist.add(5);
//        arlist.add(3);
//        arlist.add(8);
//
//        arlist2.add(50);
//        arlist2.add(30);
//        arlist2.add(80);
//        System.out.println(arlist);
//        System.out.println(arlist2);
//
//        arlist.addAll(arlist2);
//        System.out.println(arlist);
//        Collections.sort(arlist, Collections.reverseOrder());
//
//        System.out.println(arlist);
        //Collections.sort(arlist, Collections.reverseOrder());
        //System.out.println(arlist);
        System.out.println("before heapifying");
        printArray(arr);
        heapsort(arr);
//
        System.out.println("after heapifying");
        printArray(arr);
//
//        Arrays.sort(arr);



    }

    
}
