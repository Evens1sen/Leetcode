package binary;

public class LC875KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {1000000000};
        int h = 2;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        for (int num : piles) {
            max = Math.max(max, num);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(piles, h, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    // Can eat up piles within h hours with speed x
    public static boolean check(int[] piles, int h, int x) {
        for (int num : piles) {
            if (num <= x) {
                h--;
            } else {
                h -= (num + x - 1) / x; // Ceiling function using floor arithmetic
            }
        }
        return h >= 0;
    }
}
