package searching;

import java.util.ArrayList;
import java.util.List;

public class LC267PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        Character center = null;
        char[] half = new char[s.length() / 2];

        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                if (center != null) return res;
                center = (char) i;
            }
            for (int k = 0; k < count[i] / 2; k++)
                half[j++] = (char) i;
        }

        permutation(half, center, new boolean[half.length], new StringBuilder(), res);
        return res;
    }

    public void permutation(char[] half, Character center, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == half.length) {
            String tmp = sb.toString();
            if (center == null) {
                tmp += sb.reverse().toString();
            } else {
                tmp = tmp + center + sb.reverse().toString();
            }
            res.add(tmp);
            sb.reverse();
            return;
        }
        for (int i = 0; i < half.length; i++) {
            if (used[i] || i > 0 && !used[i - 1] && half[i] == half[i - 1])
                continue;
            used[i] = true;
            sb.append(half[i]);
            permutation(half, center, used, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
