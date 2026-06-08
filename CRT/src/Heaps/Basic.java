package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Basic{
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(10);
        minHeap.offer(20);

        System.out.println(minHeap.remove());
        System.out.println(minHeap.poll());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.offer(20);

        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.poll());
    }
}