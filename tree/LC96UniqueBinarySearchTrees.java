package tree;

public class LC96UniqueBinarySearchTrees {

    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return countTrees(1, n);
    }

    public int countTrees(int left, int right) {
        if (left > right) {
            return 1;
        }

        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int res = 0;
        for (int i = left; i <= right; i++) {
            res += countTrees(left, i - 1) * countTrees(i + 1, right);
        }

        memo[left][right] = res;
        return res;
    }

}
