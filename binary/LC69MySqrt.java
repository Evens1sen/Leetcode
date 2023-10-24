package binary;

public class LC69MySqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
}
