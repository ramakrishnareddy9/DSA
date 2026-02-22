package PracticeProblems.TwoPointers;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray2 {
    static void removeDuplicates(int arr[]){
        if(arr.length == 0){
            return;
        }

        int i = 2;
        for(int j = 2;j < arr.length;j++){
            if(arr[j] != arr[i - 2]){
                arr[i] = arr[j];
                i++;
            }
        }
        for(int j = 0;j < i;j++){
            System.out.print(arr[j] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        removeDuplicates(arr);
        s.close();
    }
}
