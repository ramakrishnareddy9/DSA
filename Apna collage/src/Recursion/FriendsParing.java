package Recursion;

import java.util.Scanner;

public class FriendsParing {

    static int friendsParing(int n){
        if(n == 1 || n == 2){
            return n;
        }

        int single = friendsParing(n - 1);
        int pair = friendsParing(n - 2) * (n - 1);

        return single + pair;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(friendsParing(n));
        s.close();
    }
}
