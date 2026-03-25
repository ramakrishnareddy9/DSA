package Recursion.Basic;

import java.util.Scanner;

public class Power {
    // O(n)
    static double power(double base, int exp){
        if(exp == 0){
            return 1;
        }
        if(exp < 0){
            return 1 / power(base, -exp);
        }
        return base * power(base, exp - 1);
    }
    // O(log n)
    static double powerOptimized(double base, int exp){
        if(exp == 0){
            return 1;
        }
        if(exp < 0){
            return 1 / powerOptimized(base, -exp);
        }
        double half = powerOptimized(base, exp / 2);
        if(exp % 2 == 0){
            return half * half;
        } else {
            return base * half * half;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double base = s.nextDouble();
        int exp = s.nextInt();

        System.out.println(power(base, exp));
        System.out.println(powerOptimized(base, exp));

        s.close();
    }
}