package SortingAndSearching;

public class MregeSort {
    static void Conqure(int a[], int si, int ei, int mid) {
        int merged[] = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;
        while (idx1 <= mid && idx2 <= ei) {
            if (a[idx1] <= a[idx2]) {
                merged[x++] = a[idx1++];
            } else {
                merged[x++] = a[idx2++];
            }
        }
        while (idx1 <= mid) {
            merged[x++] = a[idx1++];
        }
        while (idx2 <= ei) {
            merged[x++] = a[idx2++];
        }
        for (int i = 0, j = si; i < ei - si + 1; i++, j++) {
            a[j] = merged[i];
        }
    }

    static void mergSort(int a[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergSort(a, si, mid);
        mergSort(a, mid + 1, ei);
        Conqure(a, si, ei, mid);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
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

    static void mergeSort1(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort1(arr, left, mid);
            mergeSort1(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int a[] = { 90, 75, 34, 1, 56, 2, 6, 8 };
        mergSort(a, 0, a.length - 1);
        for (int n : a) {
            System.out.print(n + " ");
        }
    }
}


