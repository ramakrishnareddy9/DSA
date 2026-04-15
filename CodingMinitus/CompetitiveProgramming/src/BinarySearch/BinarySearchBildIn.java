package BinarySearch;

import java.util.Arrays;

public class BinarySearchBildIn {
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50};
        int n = Arrays.binarySearch(arr, 40);
        System.out.println(n);
    }
}
