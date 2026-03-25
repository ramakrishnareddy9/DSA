package Recursion.DivideAndConqure;

public class QuickSort {
    static int partition(int[] arr, int s, int e) {
        if (arr == null || s >= e) {
            return s;
        }

        int pivot = arr[e];
        int i = s - 1;

        for (int j = s; j < e; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[e];
        arr[e] = temp;

        return i + 1;
    }

    static void quickSort(int[] arr, int s, int e) {
        if (arr == null || s >= e) {
            return;
        }

        int pi = partition(arr, s, e);

        quickSort(arr, s, pi - 1);
        quickSort(arr, pi + 1, e);
    }

    static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i + 1 < arr.length ? " " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3, 7};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
