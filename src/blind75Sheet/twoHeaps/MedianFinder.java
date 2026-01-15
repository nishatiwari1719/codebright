package blind75Sheet.twoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    // Max-heap: stores the smaller half of the numbers
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // Min-heap: stores the larger half of the numbers
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // True when total number of elements is even
    private boolean isEven = true;

    public MedianFinder() {
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();

        // Test Case 1
        System.out.println("addNum(1)");
        obj.addNum(1);
        System.out.println("addNum(2)");
        obj.addNum(2);
        System.out.println("findMedian() -> " + obj.findMedian()); // 1.5
        System.out.println("addNum(3)");
        obj.addNum(3);
        System.out.println("findMedian() -> " + obj.findMedian()); // 2.0
    }

    public void addNum(int num) {
        if (isEven) {
            // Add to min-heap first, then move smallest to max-heap
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            // Add to max-heap first, then move largest to min-heap
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if (isEven) {
            // Median is the average of the two middle values
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Max-heap has one extra element
            return maxHeap.peek();
        }
    }
}

/**
 * TC: O(nlogn)
 * SC: O(n)
 */
