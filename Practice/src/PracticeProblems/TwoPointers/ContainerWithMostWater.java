package PracticeProblems.TwoPointers;

import java.util.Scanner;

public class ContainerWithMostWater {
    static int containerWithMostWater(int []height){
        int i = 0,j = height.length - 1;
        int maxArea = 0;

        while(i < j){
            int area = Math.min(height[i],height[j]);
            area *= (j-i);
            maxArea = Math.max(maxArea, area);
            if(height[i] < height[j]){
                i++;
            }else j--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(containerWithMostWater(arr));
        s.close();
    }
}
