package binarySearch;

public class LC278FirstBadVersion {
    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    boolean isBadVersion(int version){
        return true;
    }
}
