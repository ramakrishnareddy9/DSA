package linkedlists;
public class DLinkedList {
	Node head;
	public DLinkedList() {
		this.head=null;
	}
	void insertFront(int val) {
		if(head==null)
			head = new Node(val);
		else {
			Node newNode = new Node(val);
			newNode.next=head;
			head.prev=newNode;
			head = newNode;
		}
	}
	void insertLast(int val) {
		if(head==null)
			head = new Node(val);
		else {
			Node temp = head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			Node newNode = new Node(val);
			temp.next=newNode;
			newNode.prev=temp;
		}
	}
	void insertAtPos(int pos, int val) {
		if(pos==0)
			insertFront(val);
		else {
			Node temp = head;
			for(int i=0;i<pos-1;i++) {
				if(temp.next==null) {
					System.out.println("pos not available");
					return;
				}
				temp = temp.next;
			}
			Node newNode = new Node(val);
			newNode.next=temp.next;
			temp.next.prev=newNode;
			temp.next=newNode;
			newNode.prev=temp;
		}
	}
	int deleteFront() {
		int data;
		if(head==null) {
			System.out.println("list is empty");
			return 0;
		}
		else {
			data = head.val;
			head = head.next;
			head.prev=null;
		}
		return data;
	}
	int deleteLast() {
		int data;
		if(head==null) {
			System.out.println("list is empty");
			return 0;
		}
		else if(head.next==null) {
			data = head.val;
			head = null;
		}
		else {
			Node temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			data = temp.next.val;
			temp.next=null;
		}
		return data;
	}
	int deleteAtPos(int pos) {
		int data;
		if(head==null) {
			return -1;
		}
		else {
			if(pos==0)
				return deleteFront();
			else {
				Node temp=head;
				for(int i=0;i<pos-1;i++) {
					if(temp.next==null) {
						System.out.println("pos not available");
						return -1;
					}
					temp=temp.next;
				}
				data = temp.next.val;
				temp.next = temp.next.next;
			}
			return data;
		}
	}
	void printList() {
		//forward traversal
		Node temp=head;
		while(temp.next!=null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
		System.out.println(temp.val+"->END");
		
		//backward traversal
		Node first=temp;
		while(first.prev!=null) {
			System.out.print(first.val+"->");
			first=first.prev;
		}
		System.out.println(first.val+"->END");
	}
	boolean search(int val) {
		Node temp=head;
		while(temp!=null) {
			if(temp.val==val)
				return true;
			temp=temp.next;
		}
		return false;
	}
	class Node{
		int val;
		Node next;
		Node prev;
		Node(int val){
			this.val = val;
			this.next=null;
			this.prev=null;
		}
	}
}
