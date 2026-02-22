package Recursion;

import java.util.Scanner;

public class Tiling {
    static int tiling(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int vertical = tiling(n - 1);
        int horizontal = tiling(n - 2);

        return vertical + horizontal;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(tiling(n));
        s.close();
    }
}
