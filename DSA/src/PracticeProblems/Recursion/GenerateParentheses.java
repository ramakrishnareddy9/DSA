package PracticeProblems.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    static List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        backtracking(0,0,n,"",res);
        return res;
    }

    static void backtracking(int open,int close,int n,String s,List<String> res){
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        if (open < n) {
            backtracking(open + 1, close, n, s + "(", res);
        }

        if (close < open) {
            backtracking(open, close + 1, n, s + ")", res);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(generateParenthesis(n).toString());
        s.close();
    }
}
