package BinarySearch;

/*
Prateek Bhaiya decided to give 100% scholarships to the needy students by taking an admission test. However, in order to avoid any losses at the institute, he came up with a solution. Coding Blocks has N students and M discount coupons. A student will get 100% waiver if he gets X discount coupons.
However in order to get more discount coupons in addition to those M, Bhaiya decided that some students who perform badly in the admission tests, need to pay additional amount equivalent to Y discount coupons, i.e. good students earn discount coupons and weak students need to pay coupons to get admission.
Find out the maximum number of students who can get 100% waiver in their admission fees.

Note: Bhaiya will try his best to give 100% discount to maximum students possible.

Input Format:
    The first line contains 4 integers N M X Y

Constraints : 1 ≤ N, M, X, Y ≤ 10^9

Output Format:
    Print a single integer — the maximum number of students who can get 100% waiver.

Sample Input
    5 10 5 2
Sample Output
    4
*/

public class WinningScholarship {

/*
    N → totalStudents
    M → initialCoupons
    X → couponsRequiredPerStudent
    Y → couponsPaidByWeakStudent
*/
    static long maxScholarships(long N, long M, long X, long Y) {
        long left = 0, right = N;
        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(mid, N, M, X, Y)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    static boolean isPossible(long mid, long N, long M, long X, long Y) {
        long availableCoupons = M + (N - mid) * Y;
        long requiredCoupons = mid * X;

        return availableCoupons >= requiredCoupons;
    }
}
