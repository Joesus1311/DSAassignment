package Sort;
import java.util.Arrays;
public class Bubble {
    // Bubble Sort with detailed output
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Print the array after each pass
            System.out.println("Array after pass " + (i + 1) + ": " + Arrays.toString(arr));
            if (!swapped) break; // Optimization: Stop if no swaps were made
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        System.out.println("Bubble Sort:");
        bubbleSort(array);
    }
}
