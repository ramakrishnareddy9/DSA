package Recursion;

/*
Given a ladder containing N steps, you can take a jump of 1,2 or 3 at each step. Find the number of ways to climb ladder

Input :
    n = 4
Output :
    7
*/

public class ClimbingLader {
    static int climbLadder(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;
        return climbLadder(n - 1) + climbLadder(n - 2) + climbLadder(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(climbLadder(4));
    }
}
