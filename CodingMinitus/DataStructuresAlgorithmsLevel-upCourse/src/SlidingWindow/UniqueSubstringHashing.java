package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, write a function to find the largest substring with unique characters (no duplicates)

Sample Input :
    prateekbhaiya
    aabcb
Sample Output :
    ekbhaiy
    abc
*/

public class UniqueSubstringHashing {

    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int count = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
                count = i - left;
            }
            map.put(c, i);
            count++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        
    }
}
