package linkedlists;
public class CircularSLinkedListTest {
	public static void main(String[] args) {
		CircularSLinkedList list = new CircularSLinkedList();
		System.out.println(list.head);
		list.deleteFront();
		list.insertFront(10);
		list.insertFront(20);
		list.insertFront(30);
		list.insertFront(40);
		list.insertFront(70);
		list.insertFront(60);
		list.insertFront(90);
		System.out.println(list.head.val);
		System.out.println(list.tail.val);
		list.printList();
		list.insertAtPos(5, 50);
		list.printList();
		list.deleteFront();
		list.printList();
		list.deleteFront();
		list.printList();
		list.deleteAtPos(0);
		list.printList();
	}
}