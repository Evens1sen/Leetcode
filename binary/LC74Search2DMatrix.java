package binary;

public class LC74Search2DMatrix {

    // The idea is that we can map a 2D matrix into 1D array
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                left = mid + 1;
            } else if (x > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
