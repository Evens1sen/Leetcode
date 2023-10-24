package slideWindow;

import java.util.HashMap;
import java.util.Map;

public class LC76MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }

        Map<Character, Integer> tFreq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }

        int match = 0;
        int left = 0, right = 0;
        int min = m;
        String res = null;
        while (right < m) {
            char rightChar = s.charAt(right);
            if (tFreq.containsKey(rightChar)) {
                tFreq.put(rightChar, tFreq.get(rightChar) - 1);
                if (tFreq.get(rightChar) == 0) {
                    match++;
                }
            }

            while (match == tFreq.size()) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                if (tFreq.containsKey(leftChar)) {
                    if (tFreq.get(leftChar) == 0) {
                        match--;
                    }
                    tFreq.put(leftChar, tFreq.get(leftChar) + 1);
                }
                left++;
            }
            right++;
        }
        return res;
    }

}
