package strings;

import java.util.Scanner;

public class DevilGroup {
    static int devilGroup(String n){
        String []x = n.split("[@\\$]");
        int maxLength = 0;
        for(int i = 0;i < x.length;i++){
            maxLength = Math.max(maxLength,x[i].length() + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        System.out.println(devilGroup(n));
        s.close();
    }
}