package dynamic;

class LC303RangeSumQueryImmutable {

    class NumArray {
        private final int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }
        }

        // Prefix Sum: PrefixSum[i] = sum(nums[0...i))
        // Range Sum: sum(nums[left...right]) = PrefixSum[right + 1] - PrefixSum[left]
        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }
}