package string;

import java.util.HashSet;
import java.util.Set;

public class LC3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Set<Character> window = new HashSet<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
