package slideWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30ConcatenationWordsSubstring {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        int size = 0;
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            size += word.length();
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i + size - 1 < s.length(); i++) {
            String window = s.substring(i, i + size);
            if (check(window, wordMap)) {
                res.add(i);
            }
        }
        return res;
    }

    public static boolean check(String window, Map<String, Integer> wordMap) {
        if (window.isEmpty()) {
            return true;
        }

        boolean res = false;
        for (String word : wordMap.keySet()) {
            if (window.startsWith(word) && wordMap.get(word) > 0) {
                wordMap.put(word, wordMap.get(word) - 1);
                res |= check(window.substring(word.length()), wordMap);
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }
        return res;
    }
}
