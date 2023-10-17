package string;

public class TiktokOAOptimalStorage {

    public static void main(String[] args) {
        String word = "cba";
        int max_operations = 2;
        System.out.println(getStoredWord(word, max_operations));
        // yzwyz -> xzwxz -> wzwwz -> vzvvz
    }

    public static String getStoredWord(String word, int max_operations) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a') {
                continue;
            }

            int distance = word.charAt(i) - 'a';
            if (distance >= max_operations) {
                word = replace(word, word.charAt(i), max_operations);
                break;
            } else {
                word = replace(word, word.charAt(i), distance);
                max_operations -= distance;
            }
        }

        return word;
    }

    // Replace all the characters in range [ch - step, ch] to ch - step
    public static String replace(String word, char ch, int step) {
        char[] str = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (ch - step <= str[i] && str[i] <= ch) {
                str[i] = (char) (ch - step);
            }
        }
        return new String(str);
    }

}
