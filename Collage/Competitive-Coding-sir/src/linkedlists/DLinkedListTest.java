package linkedlists;
public class DLinkedListTest {
	public static void main(String[] args) {
		DLinkedList list = new DLinkedList();
		System.out.println(list.head);
		list.insertFront(10);
		list.printList();
		list.insertFront(20);
		list.printList();
		list.insertFront(30);
		list.printList();
		list.insertFront(40);
		list.printList();
		list.insertLast(50);
		list.printList();
		list.insertAtPos(3,60);
		list.printList();
		list.deleteFront();
		list.printList();
		list.deleteLast();
		list.printList();
		list.deleteAtPos(2);
		list.printList();
		System.out.println(list.search(20));
		System.out.println(list.search(100));
	}
}