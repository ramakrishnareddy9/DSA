package strings;

import java.util.Scanner;

public class StringRotatedBy2Places {
    static boolean isRotated(String n,String m){
        if(n.length() != m.length()) return false;

        String res = n.substring(2,n.length());
        res += n.substring(0,2);
        if(res.equals(m)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        String m = s.next();
        System.out.println(isRotated(n,m));
        s.close();
    }
}
