package strings;

import java.util.Scanner;

public class WeirdTerminal {
    static int numberOfLines(String n) {
        int count = 0;
        for(int i = 0;i < n.length();i++){
            if(n.charAt(i) == ' '){
                count++;
            }
        }
        
        return count / 2;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        System.out.println(numberOfLines(n));
        s.close();
    }
}
