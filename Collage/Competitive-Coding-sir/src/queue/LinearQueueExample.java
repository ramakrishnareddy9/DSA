package queue;
import java.util.Arrays;
class LinearQueue{
	int capacity;
	int size;
	int front;
	int rear;
	int[] data;
	public LinearQueue(int k) {
		this.capacity = k;
		this.size=0;
		this.front=-1;
		this.rear=-1;
		data = new int[k];
	}
	public boolean isFull() {
		return size==capacity;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int getFront() {
		if(isEmpty())
			return -1;
		return data[front];
	}
	public int getRear() {
		if(isEmpty())
			return -1;
		return data[rear];
	}

	public void enqueue(int val) {
		if(isFull()) {
			System.out.println("Queue is Full");
			return;
		}
		if(isEmpty()) {
			front=0;
			rear=0;
		}
		else {
			rear = rear+1;
		}
		data[rear]=val;
		size++;
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int val = data[front];
		data[front]=0;
		front = front+1;
		size--;
		return val;
	}
}
public class LinearQueueExample {
	public static void main(String[] args) {
		LinearQueue q = new LinearQueue(5);
		System.out.println(Arrays.toString(q.data));
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		System.out.println(Arrays.toString(q.data));		
		System.out.println(q.getFront());
		System.out.println(q.getRear());
		System.out.println(q.dequeue());
		System.out.println(Arrays.toString(q.data));		
		System.out.println(q.getFront());
		System.out.println(q.getRear());
		//q.enqueue(60);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(Arrays.toString(q.data));
	}

}
