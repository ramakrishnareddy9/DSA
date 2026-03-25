package ArraysAndArrayList;

/*
Given an array containing N integers, and an number S denoting a target sum.
Find two distinct integers that can pair up to form target sum. Let us assume there will be only one such pair.
Input :
    array = [10, 5, 2, 3, -6, 9, 11]
    S = 4
Output :
    [10, -6]
*/

import java.util.*;

public class Pairs {
    static List<Integer> pairs(int arr[],int target){
        List<Integer> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++){
            int diff = target - arr[i];
            if(s.contains(diff)){
                res.add(diff);
                res.add(arr[i]);
                return res;
            }
            s.add(arr[i]);
        }
        return res;
    }

    static List<Integer> pairsUsingHashMap(int arr[],int target){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int diff = target - arr[i];
            if(map.containsKey(diff)){
                res.add(map.get(diff));
                res.add(i);
                return res;
            }
            map.put(arr[i], i);
        }
        res.add(-1);
        res.add(-1);
        return res;
    }

    static List<Integer> pairsUsingTwoPointers(int arr[],int target){
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = arr.length - 1;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                res.add(arr[i]);
                res.add(arr[j]);
                return res;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] array = {10, 5, 2, 3, -6, 9, 11};
        int target = 4;
        List<Integer> result = pairs(array, target);
        System.out.println(result);
    }
}
