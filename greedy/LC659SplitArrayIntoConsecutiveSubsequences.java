package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC659SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        return greedy1(nums);
    }

    // Use Hashmap to optimize the list scanning
    public boolean greedy1(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> tail = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            // 如果 num 已经被用到其他子序列中则无法再被用到
            if (freq.get(num) == 0) {
                continue;
            }
            // 尝试将 num 接到之前的某个序列后面
            if (tail.containsKey(num - 1) && tail.get(num - 1) > 0) {
                // num 可以接到之前的某个序列后面
                freq.put(num, freq.get(num) - 1);
                tail.put(num - 1, tail.get(num - 1) - 1);
                tail.put(num, tail.getOrDefault(num, 0) + 1);
            } else if (freq.containsKey(num) && freq.get(num) > 0
                    && freq.containsKey(num + 1) && freq.get(num + 1) > 0
                    && freq.containsKey(num + 2) && freq.get(num + 2) > 0) {
                // 第二种情况，新建一个长度为 3 的子序列 [num, num+1, num+2]
                freq.put(num, freq.get(num) - 1);
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean greedy0(int[] nums) {
        List<List<Integer>> sequences = new ArrayList<>();
        for (int num : nums) {
            boolean added = false;
            for (int i = sequences.size() - 1; i >= 0; i--) {
                List<Integer> cur = sequences.get(i);
                if (cur.get(cur.size() - 1) + 1 == num) {
                    cur.add(num);
                    added = true;
                    break;
                }
            }
            if (!added) {
                List<Integer> toAdd = new ArrayList<>();
                toAdd.add(num);
                sequences.add(toAdd);
            }
        }

        for (List<Integer> cur : sequences) {
            if (cur.size() < 3) {
                return false;
            }
        }
        return true;
    }
}
