package Recursion;

public class SubSetOfString {
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
