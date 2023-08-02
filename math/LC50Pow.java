package math;

public class LC50Pow {

    public int recursiveQuickPower(int x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 != 0) {
            return recursiveQuickPower(x, n - 1) * x;
        } else {
            int temp = recursiveQuickPower(x, n / 2); // Save the result
            return temp * temp;
        }
    }

    public int iterativeQuickPower(int x, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
