package SortingAndSearching;

public class MergeSort {

    // IMP 1 : Interview Style Merge Sort
    // Uses a single temporary array during merge

    static void mergeInterviewStyle(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];
        int left = si;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= ei) {
            if (arr[left] <= arr[right]) {
                merged[k++] = arr[left++];
            } else {
                merged[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            merged[k++] = arr[left++];
        }

        while (right <= ei) {
            merged[k++] = arr[right++];
        }

        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    static void mergeSortInterviewStyle(int arr[], int si, int ei) {
        if (si >= ei) return;
        int mid = si + (ei - si) / 2;
        mergeSortInterviewStyle(arr, si, mid);
        mergeSortInterviewStyle(arr, mid + 1, ei);
        mergeInterviewStyle(arr, si, mid, ei);
    }

    // IMP 2 : Textbook Style Merge Sort
    // Creates left[] and right[] temporary arrays
    static void mergeTextbookStyle(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    static void mergeSortTextbookStyle(int arr[], int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortTextbookStyle(arr, left, mid);
        mergeSortTextbookStyle(arr, mid + 1, right);
        mergeTextbookStyle(arr, left, mid, right);
    }

    public static void main(String[] args) {
        int arr[] = { 90, 75, 34, 1, 56, 2, 6, 8 };
        mergeSortInterviewStyle(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}