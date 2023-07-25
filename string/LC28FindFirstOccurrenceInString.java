package string;

public class LC28FindFirstOccurrenceInString {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                j = 0;
            } else {
                j++;
            }

            if (j == needle.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }
}
