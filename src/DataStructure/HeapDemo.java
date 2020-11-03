package DataStructure;

public class HeapDemo {
    public static void main(String[] args) {
        int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
        System.out.println("Before Sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Heap Sort
        heapSort(arr);

        System.out.println();
        System.out.println("After Sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void heapSort(int[] arr) {
        for(int i = arr.length/2; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }
    }

    private static void heapAdjust(int[] arr, int i, int length) {
    }
}
