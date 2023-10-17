package searching;

import java.util.ArrayList;
import java.util.List;

public class LC17LetterCombinations {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static String[] keysMapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> res = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return res;
        }

        backtracking(0, new StringBuilder(), digits);
        return res;
    }

    public static void backtracking(int index, StringBuilder path, String dights) {
        if (index == dights.length()) {
            res.add(path.toString());
            return;
        }

        char[] choices = keysMapping[dights.charAt(index) - '0'].toCharArray();
        for (char ch : choices) {
            path.append(ch);
            backtracking(index + 1, path, dights);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
