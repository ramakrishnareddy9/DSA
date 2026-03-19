package Searching;

import java.util.Scanner;

public class LinearSearch{
    static boolean linearSearch(int arr[], int target){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == target){
                return true;
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
        System.out.println(linearSearch(arr,target));
        s.close();
    }
}