package tree;

public class LC307RangeSumQuery {

    static Node[] tree;

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int n = nums.length;
        tree = new Node[4 * n]; // Starting from index 1
        buildTree(nums, 1, 0, n - 1);
        System.out.println(sumRange(0, 2));
        update(1, 2);
        System.out.println(sumRange(0, 2));
    }

    public static void buildTree(int[] nums, int index, int left, int right) {
        if (left == right) {
            tree[index] = new Node(left, right, nums[left]);
            return;
        }

        tree[index] = new Node(left, right, 0);

        int mid = left + (right - left) / 2;
        buildTree(nums, index * 2, left, mid);
        buildTree(nums, index * 2 + 1, mid + 1, right);

        tree[index].sum = tree[index * 2].sum + tree[index * 2 + 1].sum;
    }

    public static void update(int index, int val) {
        modify(1, index, val);
    }

    public static void modify(int root, int index, int val) {
        if (tree[root].left == tree[root].right && tree[root].left == index) {
            tree[root].sum = val;
            return;
        }

        int mid = (tree[root].left + tree[root].right) / 2;
        if (index <= mid) {
            modify(root * 2, index, val);
        } else {
            modify(root * 2 + 1, index, val);
        }
        tree[root].sum = tree[root * 2].sum + tree[root * 2 + 1].sum;
    }

    public static int sumRange(int left, int right) {
        return searchRange(1, left, right);
    }

    public static int searchRange(int index, int left, int right) {
        if (tree[index].left == left && tree[index].right == right) {
            return tree[index].sum;
        }

        int mid = (tree[index].left + tree[index].right) / 2;
        if (right <= mid) {
            return searchRange(index * 2, left, right);
        } else if (left > mid) {
            return searchRange(index * 2 + 1, left, right);
        } else {
            return searchRange(index * 2, left, mid) + searchRange(index * 2 + 1, mid + 1, right);
        }
    }

    static class Node {
        int left;
        int right;
        int sum;

        public Node(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }
    }
}
