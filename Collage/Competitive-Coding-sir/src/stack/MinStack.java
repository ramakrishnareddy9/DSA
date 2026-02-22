package stack;
import java.util.Stack;
public class MinStack {
    Stack<int[]> stack = new Stack<>();        
    
    public void push(int val) {
    	if(!stack.isEmpty())
    		stack.push(new int[]{val, Math.min(val,stack.peek()[1])});
    	else
    		stack.push(new int[] {val,val});
    }
    
    public void pop() {
    	if(!stack.isEmpty())
    		stack.pop();
    }
    
    public int top() {
    	if(!stack.isEmpty())
    		return stack.peek()[0];
    	return 0;
    }
    
    public int getMin() {
    	if(!stack.isEmpty())
    		return stack.peek()[1];
    	return 0;
    }
    public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
	}
}
