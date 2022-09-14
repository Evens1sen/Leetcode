package tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC648ReplaceWords {

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        String[] words = sentence.split(" ");
        for (String word : words) {
            trie.insert(word);
        }

        dictionary.sort(Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            for (String root : dictionary) {
                if (trie.startsWith(root)) {
                    words[i] = root;
                }
            }
        }

        return String.join(" ", words);
    }
}
