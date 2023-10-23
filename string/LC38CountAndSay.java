package string;

public class LC38CountAndSay {

    public static void main(String[] args) {
        System.out.println(sayNumber("3322251"));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        return sayNumber(countAndSay(n - 1));
    }

    public static String sayNumber(String n) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        while (right < n.length()) {
            if (n.charAt(left) == n.charAt(right)) {
                right++;
            } else {
                sb.append(right - left);
                sb.append(n.charAt(left));
                left = right;
            }
        }
        sb.append(right - left);
        sb.append(n.charAt(left));

        return sb.toString();
    }
}
