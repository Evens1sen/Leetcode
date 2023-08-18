package string;

public class LC13Roman2Integer {

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                res += getValue(s.charAt(i));
            } else if (getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                res -= getValue(s.charAt(i));
            } else {
                res += getValue(s.charAt(i));
            }
        }
        return res;
    }

    public int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };

    }
}
