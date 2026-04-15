package Arrays;

public class TrappingRainWater {
    static int trap(int[] height) {
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
}
