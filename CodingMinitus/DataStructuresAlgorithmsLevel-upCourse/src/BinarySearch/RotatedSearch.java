package BinarySearch;

/*
Write a function that takes input an sorted array of distinct integers, which is rotated about a pivot point and finds the index of any given element.

Sample Input:
    [7, 9, 10, 1, 2, 3, 4, 5, 6]
    element = 4
Sample Output:
    6
*/

public class RotatedSearch {
    static int rotatedSearch(int arr[],int target){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;

            if(arr[mid] == target) return mid;

            if(arr[l] <= arr[mid]){
                if(target >= arr[l] && target <= arr[mid]) r = mid - 1;
                else l = mid + 1;
            }
            else{
                if(target >= arr[mid] && target <= arr[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{7, 9, 10, 1, 2, 3, 4, 5, 6};
        int result = rotatedSearch(arr, 4);
        System.out.println(result);
    }
}
