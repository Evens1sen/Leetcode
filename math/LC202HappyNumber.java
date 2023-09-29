package math;

public class LC202HappyNumber {

    public boolean isHappy(int n) {
        int times = 1000;
        while (times > 0) {
            n = calculate(n);
            if (n == 1) {
                return true;
            }
            times--;
        }
        return false;
    }

    public int calculate(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n = n / 10;
        }
        return res;
    }
}
