package Patterns;

import java.util.Scanner;

public class RightAngleTriangle {
    static void rightAngleTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        rightAngleTriangle(n);
        s.close();
    }
}
