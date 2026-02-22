package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CopyCatExam {
    static int copyCat(String n,String m){
        if(n.length() != m.length()) return 0;

        Set<Character> set = new HashSet<>();
        for(int i = 0;i < m.length();i++){
            set.add(m.charAt(i));
        }
        for(int i = 0;i < m.length();i++){
            if(!set.contains(n.charAt(i))) return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        String m = s.next();
        System.out.println(copyCat(n,m));
        s.close();
    }
}
