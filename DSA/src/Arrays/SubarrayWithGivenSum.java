// Subarray with given sum 
// Given an array arr[ ] of non-negative integers and an integer sum. Find the 
// sub-array that adds to the given sum. Print the start and end index of the 
// sub-array. 
// NOTE: 
// There may be more than one sub-array with sum as given sum , print the first such array. 
// Input: 
// 1 4 20 3 10 5 
// 33 
// Output: 
// 2 4 

import java.util.*;

public class SubarrayWithGivenSum {
    static int[] subarraySum(int arr[],int target){
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                return new int[]{map.get(sum - target) + 1,i};
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = s.nextInt();
        }
        int t = s.nextInt();
        System.out.println(Arrays.toString(subarraySum(arr,t)));
        s.close();
    }
}
