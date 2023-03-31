package searching;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);
        System.out.println(subsets.toString());
    }

    static List<List<Integer>> subsets = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtracking(nums, track, 0);
        return subsets;
    }

    public static void backtracking(int[] nums, List<Integer> track, int start) {
        subsets.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtracking(nums, track, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
