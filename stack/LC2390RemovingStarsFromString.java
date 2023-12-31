package stack;

import java.util.LinkedList;

public class LC2390RemovingStarsFromString {

    public static String removeStars(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                linkedList.add(ch);
            } else {
                linkedList.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : linkedList) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
