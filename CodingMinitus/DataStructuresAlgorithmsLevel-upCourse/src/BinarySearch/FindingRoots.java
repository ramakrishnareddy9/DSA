package BinarySearch;

/*
    Given an integer N and an integer P,you need find the square root of number N up to P places.Do it without using a libary function
    Input :
        N = 10, M = 3
    Output :
        3.162
*/

public class FindingRoots {
    // n -> number m -> decimal points
    static double findRoots(int n,int m) {
        int l = 0, r = n;
        double res = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;

            if(mid * mid == n){
                res = mid;
                break;
            }
            if(mid * mid < n){
                res = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        double decimal = 0.1;
        for (int i = 0; i < m; i++) {
            while ((res + decimal) * (res + decimal) <= n) {
                res += decimal;
            }
            decimal /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findRoots(10, 3));
    }
}
