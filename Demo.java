import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.zip.InflaterInputStream;

public class Demo {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }

        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int min = m + 1;
        String minWindow = "";
        sFreq.put(s.charAt(left), sFreq.getOrDefault(s.charAt(left), 0) + 1);
        while (left <= right && right < m) {
            if (check(sFreq, tFreq)) {
                int size = right - left + 1;
                if (size < min) {
                    min = size;
                    minWindow = s.substring(left, right + 1);
                }
                sFreq.put(s.charAt(left), sFreq.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            } else {
                right++;
                if (right < m) {
                    sFreq.put(s.charAt(right), sFreq.getOrDefault(s.charAt(right), 0) + 1);
                }
            }
        }

        return minWindow;
    }

    public static boolean check(Map<Character, Integer> sFreq, Map<Character, Integer> tFreq) {
        for (Map.Entry<Character, Integer> tEntry : tFreq.entrySet()) {
            Character ch = tEntry.getKey();
            Integer freq = tEntry.getValue();
            if (!(sFreq.containsKey(ch) && sFreq.get(ch) >= freq)) {
                return false;
            }
        }
        return true;
    }


}
