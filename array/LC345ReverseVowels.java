package array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC345ReverseVowels {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] result = new char[s.length()];

        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (!vowels.contains(s.charAt(i))) {
                result[i] = s.charAt(i);
                i++;
            } else if (!vowels.contains(s.charAt(j))) {
                result[j] = s.charAt(j);
                j--;
            } else {
                result[i] = s.charAt(j);
                result[j] = s.charAt(i);
                i++;
                j--;
            }
        }

        return new String(result);
    }
}
