package trees;
import java.util.Arrays;
public class TreeArrayBasedImplementation {
	public static void main(String[] args) {
		ArrayTree tree = new ArrayTree();
		System.out.println(Arrays.toString(tree.data));
		tree.setRoot(10);
		tree.setLeft(0,20);
		tree.setRight(0,30);
		tree.setLeft(1,40);
		tree.setRight(1,50);
		tree.setLeft(2,60);
		tree.setRight(2,70);
		tree.setLeft(3,80);
		tree.setRight(3,90);
		tree.setLeft(4,100);
		tree.setRight(4,110);		
		System.out.println(Arrays.toString(tree.data));
		tree.setLeft(2,160);
		tree.setRight(3,170);
		tree.setRoot(200);
		System.out.println(tree.getParent(7));
	}
}
class ArrayTree{
	int[] data = new int[10];
	void setRoot(int val) {
		if(data[0]==0)
			data[0] = val;
		else 
			System.out.println("root already exists");
	}
	void setLeft(int parent, int childData) {
		if(data[parent]!=0) {
			int left = 2*parent+1;
			if(left>=10)
				System.out.println("out of range");
			else if(data[left]==0)
				data[left]=childData;
			else 
				System.out.println("left child already exists");
		}
		else {
			System.out.println("parent not exists");
		}
	}
	void setRight(int parent, int childData) {
		if(data[parent]!=0) {
			int right = 2*parent+2;
			if(right>=10)
				System.out.println("out of range");
			else if(data[right]==0)
				data[right]=childData;
			else 
				System.out.println("right child already exists");
		}
		else {
			System.out.println("parent not exists");
		}
	}
	int getLeft(int parent) {
		if(data[parent]==0) {
			System.out.println("parent not exists");
			return -1;
		}
		int left = 2*parent+1;
		if(left>=10) {
			System.out.println("left child not exists");
			return -1;
		}
		return data[2*parent+1];
	}
	int getRight(int parent) {
		if(data[parent]==0) {
			System.out.println("parent not exists");
			return -1;
		}
		int right = 2*parent+2;
		if(right>=10) {
			System.out.println("left child not exists");
			return -1;
		}
		return data[2*parent+2];
	}
	int getParent(int child) {
		if(data[child]==0) {
			System.out.println("child not exists");
			return -1;
		}
		else {
			int parent=(child-1)/2;
			return data[parent];
		}
	}
	int getRoot() {
		if(data[0]!=0)
			return data[0];
		return -1;
	}
}