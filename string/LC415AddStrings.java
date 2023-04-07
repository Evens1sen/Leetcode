package string;

public class LC415AddStrings {

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (carry == 1 || i >= 0 || j >= 0) {
            int x = (i < 0 ? 0 : num1.charAt(i) - '0');
            int y = (j < 0 ? 0 : num2.charAt(j) - '0');
            int res = x + y + carry;
            if (res >= 10) {
                carry = 1;
                res -= 10;
            }
            sb.append(res);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}
