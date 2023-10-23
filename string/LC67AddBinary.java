package string;

import java.util.HashSet;
import java.util.Set;

public class LC67AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int length = Math.max(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            int x = (i < a.length() ? a.charAt(a.length() - i - 1) - '0' : 0);
            int y = (i < b.length() ? b.charAt(b.length() - i - 1) - '0' : 0);
            int sum = x + y + carry;
            carry = sum / 2;
            sum = sum % 2;
            res.append(sum);
        }

        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
    
}
