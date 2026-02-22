package strings;

import java.util.Arrays;

public class StringProblems {
	static void extractDigits(String str) {
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))){
				System.out.print(str.charAt(i)+" ");
			}
		}
		System.out.println();
	}
	static boolean isValid(String str) {
		int uCnt=0,dCnt=0;
		if(str.length()>=8) {
			for(char c:str.toCharArray()) {
				if(Character.isWhitespace(c))
					return false;
				else if(Character.isUpperCase(c))
					uCnt++;
				else if(Character.isDigit(c))
					dCnt++;
			}
			if(uCnt>=1 && dCnt>=1)
				return true;
		}
		return false;
	}
	static int countVowels(String str) {
		String vowels = "AEIOUaeiou";
		int count=0;
		for(char c:str.toCharArray()) {
			if(vowels.indexOf(c) != -1) {
				count++;
			}
		}
		return count;
	}
	static String reverse(String str) {
		char[] chars = str.toCharArray();
		int l=0,r=chars.length-1;
		while(l<r) {
			char temp = chars[l];
			chars[l++] = chars[r];
			chars[r--] = temp;
		}
		return Arrays.toString(chars);
	}
	static boolean isPalindrome(String str) {
		char[] chars = str.toCharArray();
		int l=0,r=chars.length-1;
		while(l<r) {
			if(chars[l] != chars[r])
				return false;
			l++;r--;
		}
		return true;
	}
	public static void main(String[] args) {
		//System.out.println(isValid("Vig_123"));
		//System.out.println(countVowels("guntur hyd"));
		//System.out.println(reverse("hyderabad"));
		System.out.println(isPalindrome("abccba"));
	}
}


