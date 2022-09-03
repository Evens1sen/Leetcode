package string;

public class LC647CountSubstrings {

    private int cnt = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstring(s, i, i);
            extendSubstring(s, i, i + 1);
        }

        return cnt;
    }

    public void extendSubstring(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            cnt++;
        }
    }
}
