package PracticeProblems.TwoPointers;

import java.util.Scanner;

public class TrappingRainWater {
    static int trappingRainWater(int height[]){
        int l = 0,r = height.length - 1;
        int x = 0, y = 0;
        int res = 0;

        while(l < r){
            x = Math.max(height[l] , x);
            y = Math.max(height[r], y);

            if(x < y){
                res += x - height[l];
                l++;
            }else{
                res += y - height[r];
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
        System.out.println(trappingRainWater(arr));
        s.close();
    }
}
