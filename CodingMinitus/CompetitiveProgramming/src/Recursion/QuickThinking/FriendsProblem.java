package Recursion.QuickThinking;

public class FriendsProblem {
	/*
	Question:
	Given N friends, each friend can either stay single or pair up with exactly one other friend.
	Find the total number of distinct ways in which all friends can go to the party.

	Example:
	N = 3
	Output = 4
	*/

	static int friendsParing(int n){
        if(n == 1 || n == 2){
            return n;
        }

        int single = friendsParing(n - 1);
        int pair = friendsParing(n - 2) * (n - 1);

        return single + pair;
    }

	public static void main(String[] args) {
		int n = 3;
		System.out.println(friendsParing(n));
	}
}
