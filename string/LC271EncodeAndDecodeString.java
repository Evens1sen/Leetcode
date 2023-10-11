package string;

import java.util.ArrayList;
import java.util.List;

public class LC271EncodeAndDecodeString {

    // word -> len(word) + "#" + word
    // ["leet", "code"] -> 4#leet4#code
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0, j = 0;
        while (j < str.length()) {
            while (Character.isDigit(str.charAt(j))) {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }

        return res;
    }
}
