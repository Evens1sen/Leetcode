package slideWindow;

public class LC424LongestRepeatingCharacterReplacement {

    /* Brute force solution:
    Iterate all the substrings [i, j] => O(n^2)
    Replace characters to the most frequent character => O(n)

    How to reduce repeat computation?
    Using slide window can reduce a scanning to O(n) time complexity
    with right to enlarge the interval and update situations
    and left to shrink the interval when condition is not satisfied
    which is commonly used in strings and arrays.
    */
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;

        int[] freq = new int[26];
        int maxFreq = 0;
        int res = 0;

        while (right < s.length()) {
            char charRight = s.charAt(right);
            freq[charRight - 'A']++;
            if (freq[charRight - 'A'] > maxFreq) {
                maxFreq = freq[charRight - 'A'];
            }

            // When shrink the window, we do not need to maintain the maxFreq
            // Because when maxChar in the right is equal => no need
            // And when maxChar is another, also no need
            // Avoiding O(n) re-scanning
            if (right - left + 1 - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
