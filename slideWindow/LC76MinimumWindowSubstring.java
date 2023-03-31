package slideWindow;

import java.util.HashMap;
import java.util.Map;

public class LC76MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s, t));
    }

    // FIXME
    public static String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0; // The slide window [left, right)
        int start = 0, minLength = 0; // Minimal window start and length
        int valid = 0; // Number of valid characters in target
        while (right < s.length()) {
            // Enlarge the window
            char ch = s.charAt(right);
            right++;

            // Only need to consider the needed characters by the target
            if (target.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(target.get(ch))) {
                    valid++;
                }
            }

            // Shrink the window
            while (valid == target.size()) {
                if (right - left < minLength) {
                    start = left;
                    minLength = right - left;
                }

                char d = s.charAt(left);
                left++;
                if (window.containsKey(d)) {
                    if (window.get(d).equals(target.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return s.substring(start, start + minLength);
    }


}
