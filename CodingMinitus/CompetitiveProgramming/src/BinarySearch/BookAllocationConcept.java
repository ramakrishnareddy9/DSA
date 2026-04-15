package BinarySearch;

/*
Problem: Allocate Minimum Number of Pages

You are given the number of pages in different books and m students. The books are arranged in ascending order of pages.
Each student must be assigned consecutive books.

Objective:
    Assign books in such a way that: The maximum number of pages assigned to any student is minimized.

Input Format :
    First line contains an integer t → number of test cases
    For each test case:
    First line contains two integers n and m
    n → number of books
    m → number of students
    Second line contains n space-separated integers
    A[i] → number of pages in each book (sorted in ascending order)
Output Format
    For each test case:
    Print a single integer → minimum possible value of the maximum pages assigned to a student
Constraints :
    1 ≤ t ≤ 50
    1 ≤ n ≤ 100
    1 ≤ m ≤ 50
    1 ≤ A[i] ≤ 1000
Important Conditions :
    Each student gets at least one book
    Books must be assigned in contiguous order
    A book cannot be split
    If m > n, return -1 (not enough books)

Input:
    1
    4 2
    12 34 67 90
Output :
    113
*/

public class BookAllocationConcept {

    static int findPages(int[] arr, int students) {
        int n = arr.length;
        
        if (students > n) return -1;
        int low = 0, high = 0;

        // Define search space
        for (int pages : arr) {
            low = Math.max(low, pages); // max single book
            high += pages;
        }

        int res = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, students, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    static boolean isPossible(int[] arr, int students, int maxPages) {
        int studentUsed = 1;
        int pagesReading = 0;

        for (int pages : arr) {

            if (pages > maxPages) return false;

            if (pagesReading + pages > maxPages) {
                studentUsed++;
                pagesReading = pages;

                if (studentUsed > students) return false;
            } else {
                pagesReading += pages;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int students = 2;
        System.out.println(findPages(arr, students)); // 113
    }
}