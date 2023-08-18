package string;

public class LC125ValidPalindrome {

    public static void main(String[] args) {
        String str = "0P";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i <= j) {
            while (i < s.length() && !isAlphaNumeric(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isAlphaNumeric(s.charAt(j))) {
                j--;
            }

            if (i < s.length() && j >= 0 && s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isAlphaNumeric(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return true;
        }

        if ('0' <= ch && ch <= '9') {
            return true;
        }

        return false;
    }
}
