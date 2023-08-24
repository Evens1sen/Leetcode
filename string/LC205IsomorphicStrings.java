package string;

import java.util.HashMap;
import java.util.Map;

public class LC205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        int seq = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (sMap.get(ch1) == null && tMap.get(ch2) == null) {
                sMap.put(ch1, seq);
                tMap.put(ch2, seq);
                seq++;
            }

            if (sMap.getOrDefault(ch1, 0) != tMap.getOrDefault(ch2, 0)) {
                return false;
            }
        }
        return true;
    }
}
