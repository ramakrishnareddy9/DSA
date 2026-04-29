/*
 * QUESTION: ACODE - Alphacode
 * Alice and Bob need to send secret messages to each other and are discussing ways to encode their messages.
 * Alice: "Let's use a very simple code: We'll assign 'A' the code word 1, 'B' will be 2, and so on down to 'Z' being assigned 26"
 * Bob: "That's a stupid code, Alice. Suppose I send you the word 'BEAN' encoded as 25114."
 * Alice: "Sure you could, but what words would you get? Other than 'BEAN', you'd get 'BEAAD', 'YAAD', 'YAN', 'YKD' and 'BEKO'. I think you would be able to figure out the correct decoding. And why would you send the word 'BEAN' anyway?"
 * Bob: "OK, maybe that's a bad example, but I bet you that if you got a string of length 5000 there would be tons of different decodings and with that many you would find at least two that would make sense."
 * Alice: "How many different decodings?"
 * Bob: "Jillions!"
 * For some reason, Alice is still unconvinced by Bob's argument, so she requires a program that will determine how many decodings there can be for a given string using her code.
 * INPUT: Input will consist of multiple input sets. Each set will consist of a single line of at most 5000 digits representing a valid encryption (for example, no line will begin with a 0). There will be no spaces between the digits. An input line of 0 will terminate the input and should not be processed.
 * OUTPUT: For each input set, output the number of possible decodings for the input string. All answers will be within the range of a 64 bit signed integer.
 */
package DynammicProgrammingOneDimensional;

import java.util.*;

public class AlphaCode {
    static String s;

    static int recursion(int i) {
        if (i == s.length())
            return 1;
        int ans = 0;
        if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
            ans += recursion(i + 1);
        }
        if ((s.length() > i + 1) && (s.charAt(i) == '1')) {
            ans += recursion(i + 2);
        }
        if ((s.length() > i + 1) && (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
            ans += recursion(i + 2);
        }
        return ans;
    }

    static int[] DP;

    static int alphaCode_Memoization(int i) {
        if (i == s.length())
            return 1;
        if (DP[i] != -1)
            return DP[i];

        DP[i] = 0;
        if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
            DP[i] += alphaCode_Memoization(i + 1);
        }
        if (i + 1 < s.length() && s.charAt(i) == '1') {
            DP[i] += alphaCode_Memoization(i + 2);
        }
        if (i + 1 < s.length() && s.charAt(i) == '2' && s.charAt(i + 1) <= '6') {
            DP[i] += alphaCode_Memoization(i + 2);
        }
        return DP[i];
    }

    public static void main(String[] args) {
        s = "25114";
        System.out.println(recursion(0));
        DP = new int[s.length()];
        Arrays.fill(DP, -1);
        System.out.println(alphaCode_Memoization(0));

    }
}
