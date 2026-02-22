/*
Given  an  array  containing  N  integers,  and  a  number  S  denoting  a  target 
sum. 
Find  two  distinct  integers  that  can  pair  up  to  form  target  sum.  Let  us 
assume there will be only one such pair. 
Input: 
7 
10 5 2 3 -6 9 11 
4 
Output: 
10 -6 
*/

import java.util.*;

class Pairs{
    static int[] findParis(int arr[],int target){
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            int diff = target - i;
            if (set.contains(diff)) {
                return new int[]{i, diff};
            }
            set.add(i);
        }
        return new int[]{-1, -1}; 
    }
    public static void main(String[] args) {
        int arr[] = {10,5,2,3,-6,9,11};
        int val = 4;

        System.out.println(Arrays.toString(findParis(arr, val)));
    }
}