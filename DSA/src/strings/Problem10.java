package strings;

import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();

        System.out.println(n.replace(' ', '-'));
        s.close();
    }
}
