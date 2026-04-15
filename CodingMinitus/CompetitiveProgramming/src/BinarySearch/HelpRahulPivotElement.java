package BinarySearch;

/*
Rahul had a sorted array of numbers from which he had to find a given number quickly. His friend by mistake rotated the array. Now Rahul doesn't have time to sort the elements again. Help him to quickly find the given number from the rotated array.
*/

public class HelpRahulPivotElement {
    static int rotatedArray(int arr[],int target){
        int l = 0,r = arr.length - 1;

        while(l <= r){
            int mid = r + (r - l) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[l] <= arr[mid]){
                if(target >= arr[l] && target <= arr[mid]) r = mid - 1;
                else l = mid + 1;
            }
            else{
                if(target >= arr[mid] && target <= arr[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}
