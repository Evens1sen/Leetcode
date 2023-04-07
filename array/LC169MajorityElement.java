package array;

class LC169MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int cnt = 0;
        for (int num : nums) {
            if (num == candidate) {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                candidate = num;
                cnt++;
            }
        }

        return candidate;
    }
}
