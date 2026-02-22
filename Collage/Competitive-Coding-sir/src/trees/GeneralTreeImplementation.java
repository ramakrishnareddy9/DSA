package trees;
import java.util.*;
public class GeneralTreeImplementation {
	public static void main(String[] args) {
		GeneralTree tree = new GeneralTree(10);
		System.out.println(tree.root.val);
		tree.addChild(tree.root,20);
		tree.addChild(tree.root,30);
		tree.addChild(tree.root,40);
		tree.printChildren(tree.root);
		
		tree.addChild(tree.root.children.get(0), 50);
		tree.addChild(tree.root.children.get(0), 60);
		tree.printChildren(tree.root.children.get(0));
		
		tree.addChild(tree.root.children.get(1), 70);
		tree.addChild(tree.root.children.get(1), 80);
		tree.printChildren(tree.root.children.get(1));
		
		tree.addChild(tree.root.children.get(2), 90);
		tree.printChildren(tree.root.children.get(2));
		tree.levelOrderTraversal(tree.root);
	}
}
class GeneralTree{
	TreeNode root;
	public GeneralTree(int rootData) {
		this.root=new TreeNode(rootData);
	}
	void addChild(TreeNode parent, int childData) {
		parent.children.add(new TreeNode(childData));
	}
	void levelOrderTraversal(TreeNode root) {
		if(root==null)
			return;
		Queue<TreeNode> queue=new ArrayDeque();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val+" ");
			queue.addAll(node.children);
		}
	}
	void printChildren(TreeNode parent) {
		for(TreeNode child:parent.children) {
			System.out.print(child.val+" ");
		}
		System.out.println();
	}
}
class TreeNode{
	int val;
	List<TreeNode> children;
	TreeNode(int val){
		this.val=val;
		this.children=new ArrayList();
	}
}
