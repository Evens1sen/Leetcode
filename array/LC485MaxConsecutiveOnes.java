package array;

public class LC485MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt = 0;
            } else {
                cnt++;
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
