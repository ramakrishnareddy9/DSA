package strings;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumOccurrence {
    static char minimumOccurrence(String n){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < n.length(); i++){
            map.put(n.charAt(i), map.getOrDefault(n.charAt(i), 0) + 1);
        }
        char res = '0';
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n.length(); i++){
            char c = n.charAt(i);
            if(map.containsKey(c) && min > map.get(c)){
                res = c;
                min = map.get(c);
                map.remove(c);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        System.out.println(minimumOccurrence(n));
        s.close();
    }
}
