package PracticeProblems.Recursion;

import java.util.Scanner;

public class Pow {
    static double pow(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        long expLong = exp;
        if (expLong < 0) {
            base = 1 / base;
            expLong = -expLong;
        }
        double result = 1.0;
        while (expLong > 0) {
            if (expLong % 2 == 1) {
                result *= base;
            }
            base *= base;
            expLong /= 2;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double base = s.nextInt();
        int exp = s.nextInt();
        System.out.println(pow(base, exp));
        s.close();
    }
}
