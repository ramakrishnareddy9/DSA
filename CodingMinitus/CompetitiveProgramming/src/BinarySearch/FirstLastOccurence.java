package BinarySearch;

import java.util.*;

public class FirstLastOccurence {

    static List<Integer> firstLastOccurence(int arr[], int key) {
        int first = findFirst(arr, key);
        int last = findLast(arr, key);
        return Arrays.asList(first, last);
    }

    static int findFirst(int[] arr, int key) {
        int l = 0, r = arr.length - 1;
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == key) {
                result = mid;
                r = mid - 1;
            } else if (arr[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }

    static int findLast(int[] arr, int key) {
        int l = 0, r = arr.length - 1;
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == key) {
                result = mid;
                l = mid + 1;
            } else if (arr[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}