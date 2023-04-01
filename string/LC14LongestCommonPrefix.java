package string;

public class LC14LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static String divideAndConquerSolution(String[] strs) {
        return LCPn(strs, 0, strs.length - 1);
    }

    // f(n) = 2f(n / 2) + O(m)
    public static String LCPn(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }

        if (left > right) {
            return "";
        }

        int mid = (left + right) / 2;
        String leftLCP = LCPn(strs, left, mid);
        String rightLCP = LCPn(strs, mid + 1, right);
        return LCP2(leftLCP, rightLCP);
    }

    // O(m)
    public static String LCP2(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()
                && str1.charAt(i) == str2.charAt(j)) {
            i++;
            j++;
        }

        return str1.substring(0, i);
    }
}
