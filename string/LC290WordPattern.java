package string;

import java.util.HashMap;
import java.util.Map;

public class LC290WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = strs[i];
            if (!map.containsKey(ch)) {
                if (map.containsValue(word)) {
                    return false;
                }
                map.put(ch, word);
            } else {
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            }
        }

        return true;
    }
}
