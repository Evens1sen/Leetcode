package sorting;

import java.util.PriorityQueue;

public class LC295MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public LC295MedianFinder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
            if (minHeap.size() + 1 < maxHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
        } else {
            minHeap.add(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if (size % 2 != 0) {
            return (double) maxHeap.peek();
        } else {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
