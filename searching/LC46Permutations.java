package searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(permute(nums));
    }

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(0, new ArrayList<>(), visited, nums);
        return res;
    }

    public static void dfs(int depth, List<Integer> path, boolean[] visited, int[] nums) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path)); // Pay attention to reference type
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]); // Do operation
                visited[i] = true;
                dfs(depth + 1, path, visited, nums); // DFS recirsive call
                visited[i] = false; // Back tracking: undo the operation
                path.remove(path.size() - 1);
            }
        }

    }
}
