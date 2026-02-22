package stack;
import java.util.Stack;
public class StackExample {
	public static void main(String[] args) {
		Stack<> s1 = new Stack<>();
		System.out.println("capacity: "+s1.capacity());
		System.out.println(s1);
		s1.push(10);
		s1.push("Vignan");
		s1.push(45.67f);
		s1.push('V');
		System.out.println(s1);
		System.out.println(s1.pop());
		System.out.println("top: "+s1.peek());
		s1.pop();
		s1.pop();
		s1.pop();
		//s1.pop();
		System.out.println(s1);
		
		Stack<Integer> s2 = new Stack<>();
		System.out.println(s2.isEmpty());
		s2.push(100);
		s2.push(null);
		System.out.println(s2.isEmpty());
	}
}