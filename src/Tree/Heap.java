package Tree;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data){
        arr.add(data);

        int child  = arr.size()-1;
        int par = (child-1)/2;

        while (arr.get(child) < arr.get(par)){
            int temp = arr.get(child);
            arr.set(child, arr.get(par));
            arr.set(par, temp);

            child = par;
            par = (child-1)/2;
        }
    }

    private void heapify(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int minIdx = i;

        if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
            minIdx = left;
        }
        if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
            minIdx = right;
        }

        if(minIdx != i){
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            heapify(minIdx);
        }
    }

    public int remove(){
        int data = arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.set(arr.size()-1, data);

        arr.remove(arr.size()-1);

        heapify(0);
        return data;
    }

    public boolean isEmpty(){
        return arr.size() == 0;
    }

    public int peek(){
        return arr.get(0);
    }

    public static void main(String[] args) {

        Heap heap = new Heap();
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);

        while(!heap.isEmpty()){
            System.out.print(heap.remove()+" ");
            //heap.remove();
        }

    }
}




