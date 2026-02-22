package strings;
import java.util.Scanner;

public class Problem11 {
    static int subString(String n,String m){
        if(n.length() < m.length()) return -1;

        int count = 0;
        for (int i = 0; i <= n.length() - m.length(); i++) {
            if (n.substring(i, i + m.length()).equals(m)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        String sub = s.next();
        System.out.println(subString(n,sub));
        s.close();
    }
}
