package string;

import java.util.HashMap;
import java.util.Map;

public class Tiktok5VulnerablePassword {

    public static void main(String[] args) {
        String password = "abcdabcd";
        int max_ops = 2;
        System.out.println(getVulnerability(password, max_ops));
    }

    public static int getVulnerability(String password, int max_ops) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int right = 0; right < password.length(); right++) {
            char ch = password.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(ch));

            int distance = right - left + 1 - maxFreq;
            if (distance > max_ops) {
                char l = password.charAt(left);
                freq.put(l, freq.get(l) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
