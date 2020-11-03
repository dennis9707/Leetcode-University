package Algorithm;

public class HeapSort {
    public static void main(String[] args) {

        int arr[] = {4,6,8,5,9};
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void heapSort(int arr[]){
        System.out.println("Heap Sort");
        int temp = 0;
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr,i,arr.length);
        }

        for(int i = arr.length-1; i > 0; i--){
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0,i);
        }
    }

    /**
     *
     * @param arr  target array
     * @param i    the index number of non-leaf node
     * @param length length is the size of the heap
     */

    public static void adjustHeap(int arr[], int i, int length){
        int temp = arr[i];

        for(int k = i * 2 + 1; k < length;k = k * 2 + 1){
//            k is the left child and k + 1 is the right child
            if(arr[k] < arr[k+1]){
//            if the value of the left child node is less than right child node
                k++; // k now points to the right node
            }
            // if the child node is larger then the parent node, swap
            if(arr[k] > temp){ 
                arr[i] = arr[k];
                i = k;
            }else{
//                do not need to change if the heap structure is not being modified
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * To heapify a subtree rooted with node i which is
     *  an index in arr[]. n is size of heap
     * @param arr target array
     * @param n size of the heap
     * @param index index in the arr
     */
    public static void adjustHeapRecuesion(int arr[], int n, int index){
        int largest = index; // Initialize largest as root
        int l = 2*index + 1; // left = 2*i + 1
        int r = 2*index + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != index)
        {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            adjustHeapRecuesion(arr, n, largest);
        }
    }
}
