package math;

import java.util.Deque;
import java.util.LinkedList;

public class LC168ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int digit = columnNumber % 26;
            char ch = digit == 0 ? 'Z' : (char) ('A' + digit - 1);
            columnNumber = columnNumber / 26;
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
