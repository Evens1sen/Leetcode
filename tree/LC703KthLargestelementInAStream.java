package tree;

public class LC703KthLargestelementInAStream {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(3));
    }

    static class KthLargest {

        Heap pq;
        int k;

        public KthLargest(int k, int[] nums) {
            pq = new Heap(k + 1);
            this.k = k;
            for (int num : nums) {
                pq.add(num);
                if (pq.size > k) {
                    pq.poll();
                }
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size > k) {
                pq.poll();
            }
            return pq.size == 0 ? 0 : pq.peek();
        }

    }

    public static class Heap {
        int[] heap;
        int N;
        int size;

        public Heap(int n) {
            this.N = n;
            heap = new int[n + 1];
            size = 0;
        }

        public void add(int x) {
            size++;
            heap[size] = x;
            swim(size);
        }

        public void swim(int index) {
            while (index > 1 && heap[index] < heap[index / 2]) {
                swap(index, index / 2);
                index /= 2;
            }
        }

        public void poll() {
            heap[1] = heap[size];
            size--;
            sink(1);
        }

        public void sink(int index) {
            while (index * 2 <= size) {
                int smaller = index * 2;
                if (smaller < N && heap[smaller] > heap[smaller + 1]) {
                    smaller++;
                }

                if (heap[index] < heap[smaller]) {
                    break;
                }
                swap(index, smaller);
                index = smaller;
            }
        }

        public int peek() {
            return heap[1];
        }

        public void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

    }
}
