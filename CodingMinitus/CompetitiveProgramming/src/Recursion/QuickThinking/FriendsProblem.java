package Recursion.QuickThinking;

/*
 * Question:
 * Given n friends, each can stay single or pair with one other friend. Count all distinct valid pairings.
 */
public class FriendsProblem {

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
