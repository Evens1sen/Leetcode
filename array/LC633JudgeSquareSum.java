package array;

public class LC633JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.floor(Math.sqrt(c));
        while (i <= j) {
            long powSum = (long) i * i + (long) j * j;
            if (powSum > c) {
                j--;
            } else if (powSum < c) {
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
}
