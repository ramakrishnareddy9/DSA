// Missing number in an array 
// Given  an  array  nums  containing  N  distinct  numbers  in  the  range  [0,  N], 
// return the only number in the range that is missing from the array. 
// Input: 
// 3 
// 3 0 1 
// Output: 
// 2 

import java.util.Scanner;

public class MissingNumberInArray {
    static int missingNumber(int[] arr){
        int sum = 0;
        for(int i : arr) sum += i;
        return arr.length * (arr.length + 1) / 2 - sum;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(missingNumber(arr));
        s.close();
    }
}