package linkedlists;
import java.util.LinkedList;
public class LinkedListExample {
	public static void main(String[] args) {
		//creation
		LinkedList<Integer> list = new LinkedList();
		System.out.println(list);
		//addition
		list.add(30);
		list.add(10);
		list.add(20);
		System.out.println(list);
		list.addFirst(40);
		System.out.println(list);
		list.addLast(50);
		System.out.println(list);
		list.add(3,70);
		System.out.println(list);
		//retreival
		System.out.println(list.get(4));
		System.out.println("first: "+list.getFirst());
		System.out.println("last: "+list.getLast());
		//verification
		System.out.println(list.contains(50));
		System.out.println(list.contains(150));
		//updation
		//deletion
		list.remove(4);
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.clear();
		System.out.println(list);
	}
}