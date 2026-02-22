package trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeImplementation {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.root);
		bst.insert(7);
		bst.insert(5);
		bst.insert(10);
		bst.insert(3);
		bst.insert(8);
		bst.insert(12);
		System.out.println("InOrder:");
		bst.inOrder(bst.root);
		System.out.println();
		System.out.println("PreOrder:");
		bst.preOrder(bst.root);
		System.out.println();
		System.out.println("PostOrder:");
		bst.postOrder(bst.root);
		System.out.println();
		System.out.println("LevelOrder:");
		bst.levelOrder(bst.root);
		System.out.println();
		System.out.println("PreOrder-Stack:");
		bst.preOrderStack(bst.root);
		System.out.println();
		System.out.println("InOrder-Stack:");
		bst.inOrderStack(bst.root);
	}
}
class BinarySearchTree{
	Node root;
	public BinarySearchTree() {
		root=null;
	}
	void insert(int val) {
		root = insert(root,val);
	}
	Node insert(Node root, int val) {
		if(root==null)
			return new Node(val);
		if(val<root.val)
			root.left = insert(root.left,val);
		if(val>root.val)
			root.right=insert(root.right, val);
		return root;
	}
	void levelOrder(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.val+" ");
			if(node.left!=null)
				queue.offer(node.left);
			if(node.right!=null)
				queue.offer(node.right);
		}
	}
	void preOrderStack(Node root) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.print(current.val+" ");
			if(current.right!=null)
				stack.push(current.right);
			if(current.left!=null)
				stack.push(current.left);
		}
	}
	void inOrderStack(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		while(current!=null || !stack.isEmpty()) {
			while(current!=null) {
				stack.push(current);
				current=current.left;
			}
			Node top = stack.pop();
			System.out.print(top.val+" ");
			current=top.right;
		}
	}
	void inOrder(Node root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.val+" ");
			inOrder(root.right);
		}
	}
	void preOrder(Node root) {
		if(root!=null) {
			System.out.print(root.val+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	void postOrder(Node root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val+" ");
		}
	}
}
class Node{
	int val;
	Node left,right;
	Node(int val){
		this.val=val;
		this.left=null;
		this.right=null;
	}
}