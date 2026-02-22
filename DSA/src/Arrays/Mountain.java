// Mountain 
// Write a function that takes input an array of distinct integers, and returns 
// the length of the highest mountain. 
 
// A  mountain  is  defined  as  adjacent  integers  that  are  strictly  increasing 
// until they reach a peak, at which they become strictly decreasing. 
 
// At least 3 numbers are required to form a mountain. 
// Input: 
// 16 
// 5 6 1 2 3 4 5 4 3 2 0 1 2 3 -2 4 
// Output: 
// 9 

import java.util.Scanner;

public class Mountain {
    static int mountain(int arr[]){
        int maxCount = 0;
        int x = 0, y = 0;
        
        for (int i = 1; i < arr.length; i++) {
            
            if ((y > 0 && arr[i] > arr[i - 1]) || arr[i] == arr[i - 1]) {
                x = 0;
                y = 0;
            }
            
            if (arr[i] > arr[i - 1]) {
                x++;
            } 
            else if (arr[i] < arr[i - 1]) {
                if (x > 0) {
                    y++;
                }
            }
            
            if (x > 0 && y > 0) {
                maxCount = Math.max(maxCount, x + y + 1);
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(mountain(arr));
        s.close();
    }
}
