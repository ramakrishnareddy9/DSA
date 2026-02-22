// K-th smallest element 
// Given an array of N numbers and a  number K where K < N. Find the K-th 
// smallest  element  in  the  given  array.  Given  that  all  array  elements  are 
// distinct. 
// Input: 
// 5 
// 12 3 5 7 19 
// 2 
// Output: 
// 5 

import java.util.Arrays;
import java.util.Scanner;

public class KsmallestElement {
    static int kSmallest(int[] arr, int k){
        Arrays.sort(arr);
        return arr[k-1];
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        System.out.println(kSmallest(arr,k));
        s.close();
    }
}
