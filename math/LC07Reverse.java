package math;

public class LC07Reverse {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int carry = x % 10;
            if (res > 214748364 || (res == 214748364 && carry > 7)) {
                return 0;
            }

            if (res < -214748364 || (res == -214748364 && carry < -8)) {
                return 0;
            }

            res = res * 10 + carry;
            x /= 10;
        }
        return res;
    }

}
