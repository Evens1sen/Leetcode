package array;

import java.util.HashSet;

public class LC217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0){
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)){
                return true;
            }
            hashSet.add(num);
        }

        return false;
    }
}
