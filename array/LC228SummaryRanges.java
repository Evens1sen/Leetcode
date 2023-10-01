package array;

import java.util.ArrayList;
import java.util.List;

public class LC228SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (right != nums.length - 1 && nums[right] + 1 == nums[right + 1]) {
                right++;
            }

            if (left == right) {
                res.add(String.valueOf(nums[left]));
            } else {
                res.add(nums[left] + "->" + nums[right]);
            }

            right++;
            left = right;
        }
        return res;
    }
}
