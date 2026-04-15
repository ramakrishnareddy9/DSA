package SlidingWindow;

/*
Given two strings, one big string and one small string, find the 'smallest window' in the big string that contains all characters of the small string.
Window can have additional characters than required.
If small string has duplicates, then those duplicates must be present with same or higher count in window.

Input :
    s1 = hello_world
    s2 = lol
Output :
    llo 
*/

import java.util.*;

public class StringWindow {
    static String minWindow(String s1, String s2) {
        if (s1.length() < s2.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s2.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int matchCharCount = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s1.length()) {
            char ch = s1.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (need.containsKey(ch) && window.get(ch) <= need.get(ch)) {
                matchCharCount++;
            }

            while (matchCharCount == s2.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s1.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    matchCharCount--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s1.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s1 = "hello_world";
        String s2 = "lol";
        System.out.println(minWindow(s1, s2));
    }
}
