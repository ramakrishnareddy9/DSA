package strings;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    static String longestPalindromicSubstring(String n){
        String res = "";
        for(int i = 0; i < n.length(); i++){
            String sub = "";
            for(int j = i; j < n.length(); j++){
                sub += n.charAt(j);
                if(isPalindromic(sub)){
                    res = sub.length() > res.length() ? sub : res;
                }
            }
        }
        return res;
    }
    
    static boolean isPalindromic(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        System.out.println(longestPalindromicSubstring(n));
        s.close();
    }
}
