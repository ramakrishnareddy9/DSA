package Searching;

import java.util.Scanner;

public class InterpolationSearch {

    static boolean interpolationSearch(int arr[],int target){
        int low = 0, high = arr.length - 1;
        
        while(low <= high && target >= arr[low] && target <= arr[high]){
            int pos = low + (high - low) / (arr[high] - arr[low]) * (target - arr[low]);
            
            if(arr[pos] == target){
                return true;
            }
            if(arr[pos] < target){
                low = pos + 1;
            } else {
                high = pos - 1;
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
        System.out.println(interpolationSearch(arr,target));
        s.close();
    }
}
