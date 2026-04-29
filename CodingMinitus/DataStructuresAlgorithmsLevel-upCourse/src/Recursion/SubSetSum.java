package Recursion;

/*
Given a set of non-negative integers, and a value sum determine if there is a subset of the given set with sum equal to given sum.
Input :
    arr = [10,12,15,6,19,20]
    sum = 16
Output :
    Yes
*/

public class SubSetSum {
    static boolean subsetSum(int arr[],int sum){
        return healper(arr,sum,0,0);
    }

    static boolean healper(int arr[],int sum,int i,int curr){
        if(curr == sum) return true;
        if(arr.length == i) return false;
        return healper(arr, sum, i + 1, curr + arr[i]) || healper(arr, sum, i + 1, curr);
    }
}