package greedy;

import java.util.ArrayList;
import java.util.List;

public class LC763PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    // Greedy and sliding window
    // Time complexity: O(n)
    // Space complexity: O(26)
    public static List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        int i = left;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            if (lastIndex[s.charAt(i) - 'a'] > i) {
                right = Math.max(lastIndex[s.charAt(i) - 'a'], right);
            }
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
                right++;
            }
            i++;
        }

        return res;
    }
}
