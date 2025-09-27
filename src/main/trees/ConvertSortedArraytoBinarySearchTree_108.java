package main.trees;

public class ConvertSortedArraytoBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int h) {

        if (l > h)
            return null;

        int mid = l + (h - l) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, l, mid - 1);

        root.right = helper(nums, mid + 1, h);

        return root;

    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree_108 obj = new ConvertSortedArraytoBinarySearchTree_108();
        obj.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
