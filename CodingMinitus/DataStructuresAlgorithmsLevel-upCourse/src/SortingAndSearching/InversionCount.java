package SortingAndSearching;

/*
Given an array containing integers, you need to count the number of inversions.
Inversion : Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

sample input :
0 5 2 3 1
sample output :
3
*/

public class InversionCount {
    // brute force
    static int inversionCount(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) count++;
            }
        }
        return count;
    }

    // optimal using merge sort

}
