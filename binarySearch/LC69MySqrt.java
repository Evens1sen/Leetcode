package binarySearch;

public class LC69MySqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // Be careful about overflow
            if (square < x) {
                left = mid + 1;
            } else if (square > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }
}
