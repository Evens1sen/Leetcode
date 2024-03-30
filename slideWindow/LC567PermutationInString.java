package slideWindow;

public class LC567PermutationInString {

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            freq[ch - 'a']--;
        }

        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            char removed = s2.charAt(i - 1);
            char added = s2.charAt(i + s1.length() - 1);
            freq[removed - 'a']++;
            freq[added - 'a']--;
            if (allZero(freq)) {
                return true;
            }
        }

        return false;
    }

    public static boolean allZero(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
