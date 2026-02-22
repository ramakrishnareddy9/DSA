package linkedlists;
public class SLinkedListTest {
	public static void main(String[] args) {
		SLinkedList list = new SLinkedList();
		System.out.println(list.head);
		list.deleteFront();
		list.printList();
		list.insertLast(70);
		list.printList();
		list.deleteLast();
		list.printList();
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
		list.insertAtPos(5, 100);
		list.printList();
		list.insertBefore(20, 200);
		list.printList();
		list.deleteFront();
		list.printList();
		list.deleteLast();
		list.printList();
		list.deleteAtPos(3);
		list.printList();
		list.delete(50);
		list.printList();
		System.out.println(list.search(20));
		System.out.println(list.search(50));
	}
}