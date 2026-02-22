package linkedlists;

import linkedlists.SLinkedList.Node;

public class CircularSLinkedList {
	Node head;
	Node tail;
	public CircularSLinkedList() {
		this.head=null;
	}
	void insertFront(int val) {
		Node newNode = new Node(val);
		if(head==null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.next=head;
			head = newNode;
			tail.next=head;
		}
	}
	void insertAtPos(int pos, int val) {
		if(pos==0)
			insertFront(val);
		else {
			Node temp = head;
			for(int i=0;i<pos-1;i++) {
				if(temp.next==head) {
					System.out.println("pos not exists");
					return;
				}
				temp = temp.next;
			}
			Node newNode = new Node(val);
			newNode.next=temp.next;
			temp.next=newNode;
			if(temp==tail)
				tail=newNode;
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
			tail.next=head;
		}
		return data;
	}
	int deleteAtPos(int pos) {
		int data;
		if(head==null) {
			System.out.println("list is empty");
			return -1;
		}
		else {
			if(pos==0)
				return deleteFront();
			else {
				Node temp=head;
				for(int i=0;i<pos-1;i++) {
					if(temp.next.next==head) {
						System.out.println("pos not available");
						return -1;
					}
					temp=temp.next;
				}
				data = temp.next.val;
				if(temp.next==tail)
					tail=temp;
				temp.next=temp.next.next;
			}
			return data;
		}
	}

	void printList() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
			if(temp==head)
				break;
		}
		System.out.println("END");
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