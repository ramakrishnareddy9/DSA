package BinarySearch;

public class MonotonicSearchSpaces {

    static int squareRoot(int n) {
        int l = 0, r = n;
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long sq = (long) mid * mid;
            if (sq == n) {
                return mid;
            } else if (sq > n) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}