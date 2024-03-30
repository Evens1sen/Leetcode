package string;

public class LC28FindFirstOccurrenceInString {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(rabinKarp(haystack, needle));
    }

    public static int rabinKarp(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n) {
            return -1;
        }

        int base = 31, pow = 1;
        long mod = (long) 1e9 + 7;
        int needleHash = 0, haystackHash = 0;
        for (int i = 0; i < n; i++) {
            needleHash = needleHash * base + (needle.charAt(i) - 'a');
            haystackHash = haystackHash * base + (haystack.charAt(i) - 'a');
            if (i < n - 1) {
                pow *= base;
            }
        }
        if (haystackHash == needleHash && haystack.substring(0, n).equals(needle)) {
            return 0;
        }

        for (int i = 0; i < m - n; i++) {
            haystackHash -= pow * (haystack.charAt(i) - 'a');
            haystackHash = haystackHash * base + (haystack.charAt(i + n) - 'a');
            if (haystackHash == needleHash && haystack.substring(i + 1, i + 1 + n).equals(needle)) {
                return i + 1;
            }
        }
        return -1;
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

    public static int kmp(String s, String p) {
        int[] next = getNext(p);
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }

            if (j == p.length()) {
                return i - j;
            }
        }

        return -1;
    }

    public static int[] getNext(String p) {
        int[] next = new int[p.length()];
        int i = 1, now = 0;
        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(now)) {
                next[i] = now + 1;
                i++;
                now++;
            } else {
                if (now > 0) {
                    now = next[now - 1];
                } else {
                    next[i] = 0;
                    i++;
                }
            }
        }
        return next;
    }
}
