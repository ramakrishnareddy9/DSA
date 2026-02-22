package strings;

import java.util.Scanner;

public class JumbleWords {
    static String jumpWords(String n,String m){
        int minLen = Math.min(n.length(),m.length());
        StringBuilder s = new StringBuilder();
        for(int i = 0;i < minLen;i++){
            s.append(n.charAt(i));
            s.append(m.charAt(i));
        }
        if(n.length() > minLen){
            s.append(n.substring(minLen));
        }
        if(m.length() > minLen){
            s.append(m.substring(minLen));
        }
        return s.toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        String m = s.next();
        System.out.println(jumpWords(n,m));
        s.close();
    }
}
