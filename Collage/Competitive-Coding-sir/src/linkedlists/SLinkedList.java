package linkedlists;
public class SLinkedList {
	Node head;
	public SLinkedList() {
		this.head=null;
	}
	void insertFront(int val) {
		if(head==null)
			head = new Node(val);
		else {
			Node newNode = new Node(val);
			newNode.next=head;
			head = newNode;
		}
	}
	void printList() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
		System.out.println("END");
	}
	void insertLast(int val) {
		if(head==null)
			head = new Node(val);
		else {
			Node temp = head;
			while(temp.next!=null)
				temp=temp.next;
			Node newNode = new Node(val);
			temp.next=newNode;
		}
	}
	void insertAtPos(int pos, int val) {
		if(pos==0)
			insertFront(val);
		else {
			Node temp = head;
			for(int i=0;i<pos-1;i++) {
				if(temp.next==null) {
					System.out.println("not possible");
					return;
				}
				temp = temp.next;
			}
			Node newNode = new Node(val);
			newNode.next=temp.next;
			temp.next=newNode;
		}
	}
	void insertBefore(int node, int val) {
		if(head.val==node){
			insertFront(val);
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				if(temp.next.val==node) {
					Node newNode = new Node(val);
					newNode.next=temp.next;
					temp.next=newNode;
					return;
				}
				temp=temp.next;
			}
			if(temp.next==null)
				System.out.println("node is not available");
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
				temp.next=temp.next.next;
			}
			return data;
		}
	}
	int delete(int val) {
		int data=-1;
		if(head.val==val)
			return deleteFront();
		Node temp=head;
		while(temp.next!=null) {
			if(temp.next.val==val) {
				data = temp.next.val;
				temp.next=temp.next.next;
				return data;
			}
			temp=temp.next;
		}
		if(temp.next==null) {
			System.out.println("node not exists");
		}
		return data;
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
		Node(int val){
			this.val = val;
			this.next=null;
		}
	}
}