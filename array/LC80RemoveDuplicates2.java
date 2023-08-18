package array;

public class LC80RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            } else { // nums[j] == nums[i]
                if (i == 0 || nums[j] != nums[i - 1]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }
}
