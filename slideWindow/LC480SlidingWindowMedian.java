package slideWindow;

import java.util.TreeMap;
import java.util.TreeSet;

public class LC480SlidingWindowMedian {

    // FIXME
    public static void main(String[] args) {
//        MediaFinder mediaFinder = new MediaFinder();
//        mediaFinder.insert(1);
//        mediaFinder.insert(5);
//        mediaFinder.insert(2);
//        mediaFinder.insert(3);
//        mediaFinder.insert(5);
//        mediaFinder.insert(6);
//        System.out.println(mediaFinder.getMedian());
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        return null;
    }

    // {smaller}, {larger}
    // smaller: k + 1, larger: k for n = 2k + 1
    static class MediaFinder {
        // Set cannot store repeated numbers
        // Need to use TreeMap
        TreeMap<Integer, Integer> smaller;
        TreeMap<Integer, Integer> larger;

        int leftSize = 0;

        int rightSize = 0;

        public MediaFinder() {
            this.smaller = new TreeMap<>();
            this.larger = new TreeMap<>();
        }

//        public double getMedian() {
//            if (leftSize() == larger.size()) {
//                return ((double) smaller. + larger.first()) / 2;
//            } else {
//                return smaller.last();
//            }
//        }
//
//        public void insert(int num) {
//            if (smaller.size() == 0 && larger.size() == 0) {
//                smaller.add(num);
//            } else if (smaller.size() == larger.size()) {
//                if (num > smaller.last()) {
//                    larger.add(num);
//                    smaller.add(larger.pollFirst());
//                } else {
//                    smaller.add(num);
//                }
//            } else { // smaller = larger + 1
//                if (num > smaller.last()) {
//                    larger.add(num);
//                } else {
//                    larger.add(smaller.pollLast());
//                    smaller.add(num);
//                }
//            }
//        }
//
//        public void delete(int num) {
//            if (smaller.size() == larger.size()) {
//                if (num > smaller.last()) {
//                    larger.remove(num); // k+1, k
//                } else {
//                    smaller.remove(num); // k, k+1
//                    smaller.add(larger.pollFirst());
//                }
//            } else { // k+1, k
//                if (num > smaller.last()) {
//                    larger.remove(num);
//                    larger.add(smaller.pollLast());
//                    larger.add(smaller.pollLast());
//                } else {
//                    smaller.remove(num);
//                }
//            }
//        }
    }
}
