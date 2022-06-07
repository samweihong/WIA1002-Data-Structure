package lab10;

import java.util.Arrays;

public class Q {
    public static void selectionSortSmallest(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex]) minIndex = j;

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void selectionSortLargest(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--)
                if (arr[j] > arr[maxIndex]) maxIndex = j;

            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 7, 2, 8, 19, 3};
        selectionSortSmallest(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{45, 7, 2, 8, 19, 3};
        selectionSortLargest(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{10, 34, 2, 56, 7, 67, 88, 42};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j;
            for (j = i-1; j >= 0 && current < arr[j]; j--)
                arr[j+1] = arr[j];
            arr[j+1] = current;
        }
    }
}
