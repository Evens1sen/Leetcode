package string;

import java.util.ArrayList;
import java.util.List;

public class LC6ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int direction = 1;
        int i = 0;
        for (char ch : s.toCharArray()) {
            rows[i].append(ch);
            i += direction;
            if (i == numRows - 1 || i == 0) {
                direction = -direction;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
