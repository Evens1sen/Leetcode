package tree;

public class Heap {

    int size;
    int[] heap;

    public Heap(int N) {
        this.size = 0;
        heap = new int[N + 1];
    }

    public void insert(int val) {
        size++;
        heap[size] = val;
        swim(size);
    }

    public int deleteMax() {
        int max = heap[1];
        swap(1, size);
        size--;
        sink(1);
        return max;
    }

    public int peek() {
        return heap[1];
    }

    public void sink(int i) {
        while (i * 2 <= size) {
            int left = i * 2;
            int right = i * 2 + 1;
            int largest = i;
            if (heap[left] >= heap[largest]) {
                largest = left;
            }
            if (right <= size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest == i) {
                break;
            }
            swap(i, largest);
            i = largest;
        }
    }

    public void swim(int i) {
        while (i > 1 && heap[i] > heap[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
