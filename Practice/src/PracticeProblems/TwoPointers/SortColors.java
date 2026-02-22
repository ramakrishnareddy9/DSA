package PracticeProblems.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class SortColors {
    static void sortColors(int arr[]){
        int low = 0,mid = 0,high = arr.length - 1;
        
        while(mid <= high){
            if(arr[mid] == 0){
                swap(mid,low,arr);
                mid++;low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }else{
                swap(mid,high,arr);
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int i,int j,int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        sortColors(arr);
        s.close();
    }
}
