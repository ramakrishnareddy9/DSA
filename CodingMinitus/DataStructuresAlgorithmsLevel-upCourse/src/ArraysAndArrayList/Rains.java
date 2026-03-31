package ArraysAndArrayList;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Input :
    [0,1,0,2,1,0,1,3,2,1,2,1]
Output : 
    6
*/

/*
 * PROBLEM STATEMENT:
 * ==================
 * Given HEIGHTS OF BARS, calculate TOTAL TRAPPED RAIN WATER.
 * Water is trapped between bars if they have higher bars on both sides.
 * 
 * EXPLANATION:
 * For each bar at index i:
 * - Find max height to the left (leftMax)
 * - Find max height to the right (rightMax)
 * - Water level at i = min(leftMax, rightMax)
 * - Water trapped = max(0, water_level - height[i])
 * 
 * ALGORITHMS:
 * 1. NAIVE: For each element, find left and right max -> O(n^2)
 * 2. PRECOMPUTE: Store left and right max arrays -> O(n) time, O(n) space
 * 3. TWO POINTERS: Use pointers from both ends -> O(n) time, O(1) space
 * 
 * EXAMPLE:
 * Input heights: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 *           [            |
 *         | | |        |_|
 *        _| | | _|_| |_ | |_ |
 * Water trapped between bars: 6 units
 * 
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1) if two-pointers, O(n) if precomputing
 */
public class Rains {

    // space : o(1)
    static int trappingRainWater(int height[]){
        int l = 0,r = height.length - 1;
        int x = 0, y = 0;
        int res = 0;

        while(l < r){
            x = Math.max(height[l] , x);
            y = Math.max(height[r], y);

            if(x < y){
                res += x - height[l];
                l++;
            }else{
                res += y - height[r];
                r--;
            }
        }
        return res;
    }

    // space : o(n)
    static int trappingRainWater2(int heights[]) {
        int n = heights.length;

        if (n <= 2) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = heights[0];
        right[n - 1] = heights[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], heights[i]);
            //right[n - i - 1] = Math.max(right[n - i], heights[n - i - 1]);
        }

        for(int i = n - 2;i >= 0;i--){
            right[i] = Math.max(right[i + 1], heights[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - heights[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water (two pointers) : " + trappingRainWater(height));
        System.out.println("Trapped water (prefix/suffix) : " + trappingRainWater2(height));
    }
}
