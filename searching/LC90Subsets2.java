package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90Subsets2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), 0);
        return res;
    }

    public void backtracking(int[] nums, List<Integer> path, int index) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {

            // Pruning the duplicate subsets except the first one
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            backtracking(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
