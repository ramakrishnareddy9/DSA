package Searching;

import java.util.Scanner;

public class BinarySearch {
    static boolean binarySearch(int arr[],int target){
        int i = 0,j = arr.length - 1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();   
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();
        System.out.println(binarySearch(arr,target));
        s.close();
    }
}