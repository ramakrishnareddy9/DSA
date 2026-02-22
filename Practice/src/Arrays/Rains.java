// Rains 
// Given  N  non-negative  integers  representing  an  elevation  map  where  the 
// width of each bar is 1, compute how much water it can trap after raining. 
// Input: 
// 12 
// 0 1 0 2 1 0 1 3 2 1 2 1
// Output: 
// 6 

import java.util.Scanner;

public class Rains {
    static int rain(int arr[]){
        int arr1[] = new int[arr.length];
        int arr2[] = new int[arr.length];

        int res = 0;
        arr1[0] = arr[0];
        arr2[arr.length - 1] = arr[arr.length - 1];

        for(int i = 1;i < arr.length;i++){
            arr1[i] = Math.max(arr[i],arr1[i - 1]);
        }

        for(int i = arr.length - 2 ;i >= 0;i--){
            arr2[i] = Math.max(arr[i],arr2[i + 1]);
        }

        for(int i = 0;i < arr.length;i++){
            res += Math.min(arr1[i],arr2[i]) - arr[i];
        }
        return res;
    }

    static int rain1(int arr[]){
        int l = 0,r = arr.length - 1;
        int x = 0, y = 0;
        int res = 0;

        while(l < r){
            x = Math.max(arr[l] , x);
            y = Math.max(arr[r], y);

            if(x < y){
                res += x - arr[l];
                l++;
            }else{
                res += y - arr[r];
                r--;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(rain(arr));
        System.out.println(rain1(arr));
        s.close();
    }
}
