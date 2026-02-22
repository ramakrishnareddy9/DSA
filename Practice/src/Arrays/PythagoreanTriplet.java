// Pythagorean Triplet 
// Given an array of N integers, write a function that returns true if there is a 
// triplet (a, b, c) that satisfies a2  + b2  = c2 
// Input: 
// 5 
// 3 1 4 6 5 
// Output: 
// True There is a Pythagorean triplet (3, 4, 5). 

import java.util.Scanner;

public class PythagoreanTriplet {
    static boolean pythagoreanTriplet(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    int a = arr[i] * arr[i];
                    int b = arr[j] * arr[j];
                    int c = arr[k] * arr[k];
                    if(a + b == c || b + c == a || a + c == b){
                        return true;
                    }
                }
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
        System.out.println(pythagoreanTriplet(arr));
        s.close();
    }
}
