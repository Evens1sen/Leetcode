package array;

public class LC238ProductOfArrayExceptSelf {

    // [1, 2, 3, 4] -> [24, 12, 8, 6]
    // We use something similar to the prefix sum array
    // L[i] = arr[0]*arr[1]...arr[i-1]
    // R[i] = arr[n]*arr[n-1]...arr[i+1]
    // Therefore, res[i] = L[i] * R[i]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = leftProduct[i] * rightProduct[i];
        }
        return ans;
    }

    // Optimize the space
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int leftProduct = 1;
//        int rightProduct = 1;
//        int[] res = new int[n];
//        for(int i = 0; i < n; i++){
//            res[i] = leftProduct;
//            leftProduct *= nums[i];
//        }
//        for(int i = n - 1; i >= 0; i--){
//            res[i] *= rightProduct;
//            rightProduct *= nums[i];
//        }
//        return res;
//    }
}
