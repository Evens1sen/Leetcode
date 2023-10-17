package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47Permutations2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void backtracking(int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // Skip the results that in the wrong order
            // If nums[i-1] == nums[i], we can assume that nums[i-1] appears before nums[i]
            // So when nums[i-1] is not used, the sequence is broken.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
