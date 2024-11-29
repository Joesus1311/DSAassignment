package TimeandSpacecomplexity;

import java.util.Random;

public class SpaceComplexity {

    // Same sorting methods as before (QuickSort, MergeSort, BubbleSort)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void bubbleSort(int n, int[] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 1000;

        int[] randomArray1000_bubble = new Random().ints(size, 0, 10000000).toArray();
        int[] randomArray1000_quick = new Random().ints(size, 0, 10000000).toArray();
        int[] randomArray1000_merge = new Random().ints(size, 0, 10000000).toArray();

        Runtime runtime = Runtime.getRuntime();

        // Bubble Sort
        runtime.gc(); // Force garbage collection
        long beforeBubble = runtime.totalMemory() - runtime.freeMemory();
        bubbleSort(randomArray1000_bubble.length, randomArray1000_bubble);
        long afterBubble = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory used by Bubble Sort: " + (afterBubble - beforeBubble) + " bytes");

        // Quick Sort
        runtime.gc();
        long beforeQuick = runtime.totalMemory() - runtime.freeMemory();
        quickSort(randomArray1000_quick, 0, randomArray1000_quick.length - 1);
        long afterQuick = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory used by Quick Sort: " + (afterQuick - beforeQuick) + " bytes");

        // Merge Sort
        runtime.gc();
        long beforeMerge = runtime.totalMemory() - runtime.freeMemory();
        mergeSort(randomArray1000_merge, 0, randomArray1000_merge.length - 1);
        long afterMerge = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory used by Merge Sort: " + (afterMerge - beforeMerge) + " bytes");
    }
}
