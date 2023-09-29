package array;

import java.util.HashSet;
import java.util.Set;

public class LC219ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            if (i == nums.length) {
                break;
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        set.remove(nums[0]);
        for (int i = 1; i < nums.length - k; i++) {
            if (set.contains(nums[i + k])) {
                return true;
            }
            set.add(nums[i + k]);
            set.remove(nums[i]);
        }

        return false;
    }
}
