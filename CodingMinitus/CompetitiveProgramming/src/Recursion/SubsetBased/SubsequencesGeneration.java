package Recursion.SubsetBased;

/*
	Question:
	Given a string containing n characters, generate and print all possible subsequences
	(subsets of characters while preserving relative order).

	Sample Input:
	s = "abc"

	One possible output order:
	abc
	ab
	ac
	a
	bc
	b
	c
	""
*/

public class SubsequencesGeneration {

	static void generateSubsequence(String in, String out, int i) {
		if (i == in.length()) {
			System.out.println(out);
			return;
		}

		generateSubsequence(in, out + in.charAt(i), i + 1);
		generateSubsequence(in, out, i + 1);
	}

	public static void main(String[] args) {
		String s = "abc";
		generateSubsequence(s, "", 0);
	}
}
