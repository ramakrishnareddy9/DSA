package queue;
import java.util.*;
public class QueueOperations {
	public static void main(String[] args) {
		ArrayDeque<Integer> q = new ArrayDeque(5);
		System.out.println(q);
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		System.out.println(q);
		q.poll();
		q.poll();
		System.out.println(q);
		q.addFirst(100);
		System.out.println(q);
		q.addLast(200);
		System.out.println(q);
		q.pollFirst();
		System.out.println(q);
		q.pollLast();
		System.out.println(q);
		System.out.println(q.peek());
		System.out.println(q.peekFirst());
		System.out.println(q.peekLast());
		q.removeFirst();
		System.out.println(q);
		q.removeLast();
		System.out.println(q);
		q.poll();
		System.out.println(q.isEmpty());
	}
}