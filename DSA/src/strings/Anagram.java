package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    // O(nlogn)
    static boolean anagram(String n,String m){
        if(n.length() != m.length()) return false;
        char[] a = n.toCharArray();
        char[] b = m.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0;i < a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    // O(n)
    static boolean anagram1(String n,String m){
        if(n.length() != m.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char i : n.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (char i : m.toCharArray()) {
            if (!map.containsKey(i)) {
                return false;
            }
            map.put(i, map.get(i) - 1);
            if (map.get(i) < 0) {
                return false;
            }
        }
        for (int i : map.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        String m = s.next();
        System.out.println(anagram(n,m));
        s.close();
    }
}
