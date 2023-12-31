package slideWindow;

import java.util.Set;

public class LC1456MaximumNumberOfVowels {

    public static void main(String[] args) {
        String s = "weallloveyou";
        System.out.println(maxVowels(s, 7));
    }

    public static int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int res = 0;
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                res++;
                cnt++;
            }
        }

        for (int i = 1; i <= s.length() - k; i++) {
            if (vowels.contains(s.charAt(i - 1))) {
                cnt--;
            }
            if (vowels.contains(s.charAt(i + k - 1))) {
                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
