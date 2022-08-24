package binarySearch;

public class LC744NextGreatestLetter {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid;
            }
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}
