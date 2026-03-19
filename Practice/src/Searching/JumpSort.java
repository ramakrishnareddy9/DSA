package Searching;

import java.util.Scanner;

public class JumpSort {
    static boolean jumpSearch(int arr[],int target){
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;
        
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return false;
        }
        
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) return false;
        }
        
        return arr[prev] == target;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();   
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();
        System.out.println(jumpSearch(arr,target));
        s.close();
    }
}
