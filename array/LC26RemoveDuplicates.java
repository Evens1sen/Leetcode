package array;

public class LC26RemoveDuplicates {

    // [1, 1, 3, 4, 4, 6] -> [1, 3, 4, 6]
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        // Considering the iteration variable
        // Since i is unknown, using j
        // Update i in certain condition
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }
}
