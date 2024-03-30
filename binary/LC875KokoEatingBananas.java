package binary;

public class LC875KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int p : piles) {
            max = Math.max(max, p);
        }

        int left = 1, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!check(piles, h, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Can eat up piles within h hours with speed x
    public static boolean check(int[] piles, int h, int k) {
        int cur = 0;
        while (cur < piles.length) {
            int time = piles[cur] / k;
            if (piles[cur] % k == 0) {
                time++;
            }
            h -= time;
            cur++;
        }
        return h >= 0;
    }
}
