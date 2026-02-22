package stack;
import java.util.Stack;
public class StackPractice {
	static boolean validParenthese(String str) {
		int count = 0;
		for(char ch:str.toCharArray()) {
			if(ch=='(')
				count++;
			else if(ch==')')
				count--;
			if(count<0)
				return false;
		}
		return count==0;
	}
	static boolean validOperations(int[] operations) {
		int count = 0;
		for(int op:operations) {
			if(op==1)
				count++;
			else if(op==0)
				count--;
			if(count<0)
				return false;
		}
		return true;
	}
	static String removeOuterParentheses(String s) {
		int count = 0;
		StringBuilder res = new StringBuilder();
        for(char ch:s.toCharArray()){
        	if(ch=='(') {
        		if(++count>1)
        			res.append(ch);
        	}
        	else if(ch==')') {
        		if(--count>0)
        			res.append(ch);
        	}
        }
        return res.toString();
    }
	static String removeOuterParentheses2(String s) {
		int count = 0;
		Stack<Character> stack = new Stack();
        for(char ch:s.toCharArray()){
        	if(ch=='(') {
        		if(++count>1)
        			stack.push(ch);
        	}
        	else if(ch==')') {
        		if(--count>0)
        			stack.push(ch);
        	}
        }
		StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
        	res.append(stack.pop());
		return res.reverse().toString();
    }
    static String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> stack = new Stack();
        for(String dir:directories) {
        	if(dir.equals(".") || dir.equals(""))
        		continue;
        	else if(dir.equals("..") && !stack.isEmpty())
        		stack.pop();
        	else
        		stack.push(dir);
        }
        System.out.println(stack);
        String res = "/"+String.join("/", stack);
        return res;
    }
    static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String token:tokens) {
        	if(token.equals("+")) {
        		int b = stack.pop();
        		int a = stack.pop();
        		stack.push(a+b);
        	}
        	else if(token.equals("-")) {
        		int b = stack.pop();
        		int a = stack.pop();
        		stack.push(a-b);
        	}
        	else if(token.equals("*")) {
        		int b = stack.pop();
        		int a = stack.pop();
        		stack.push(a*b);
        	}
        	else if(token.equals("/")) {
        		int b = stack.pop();
        		int a = stack.pop();
        		stack.push(a/b);
        	}
        	else {
        		stack.push(Integer.parseInt(token));
        	}
        }
        return stack.pop();
    }
    /*
    static int longestValidParentheses(String s) {
    	int maxLen=0,count=0;
    	Stack<Character> stack = new Stack();
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)=='(')
    			stack.push(s.charAt(i));
    		else if(s.charAt(i)==')') {
    			if(!stack.isEmpty()&& stack.peek()=='(') {
    				stack.pop();
    				count += 2;
    				maxLen = Math.max(maxLen, count);
    			}
    			else
    				count=0;
    		}
    	}
    	return maxLen;
    }
    */
	public static void main(String[] args) {
		int[] operations = {1,0,1,1};
		//System.out.println(validOperations(operations));
		//System.out.println(validParenthese("9"));
		//System.out.println(removeOuterParentheses2("(()())(())(()(()))"));
		//System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
		String[] tokens = {"2","1","+","3","*"};
		String[] tokens2 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		//System.out.println(evalRPN(tokens2));
		//System.out.println(longestValidParentheses("((()(()"));
	}
}