package BinarySearch;

/*
Given a sorted array which contins repeated elements ,and an element k we need to fing the frequency of a given element
input:
    arr = [0,1,1,1,2,2,2,2,2,3,3,3,3,3,5,5,5,]
    k = 5
output :
    3
*/

public class FrequencyCount {
    static int leftIndex(int arr[], int target) {
        int l = 0, r = arr.length - 1;
        int idx = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                idx = mid;
                r = mid - 1;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return idx;
    }

    static int rightIndex(int arr[], int target) {
        int l = 0, r = arr.length - 1;
        int idx = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                idx = mid;
                l = mid + 1;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return idx;
    }

    static int freqCount(int arr[], int k) {
        int left = leftIndex(arr, k);
        int right = rightIndex(arr, k);
        if (left == -1) return 0;
        return right - left + 1;
    }
}
