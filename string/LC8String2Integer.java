package string;

public class LC8String2Integer {

    public static void main(String[] args) {
        String s = "-42";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int i = 0;
        boolean positive = true;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            positive = (s.charAt(i) == '+');
            i++;
        }

        long res = 0L;
        while (i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
            res *= 10;
            res += s.charAt(i) - '0';
            i++;
            if (res == Integer.MAX_VALUE) {
                if (positive) {
                    return Integer.MAX_VALUE;
                }
            } else if (res > Integer.MAX_VALUE) {
                if (positive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }

        if (!positive) {
            res = -res;
        }

        return (int) res;
    }
}
