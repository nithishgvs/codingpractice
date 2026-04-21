package main.trees;

public class ValidateBinarySearchTree_98 {


    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBSTHelper(root.left, min, root.val)
                && isValidBSTHelper(root.right, root.val, max);
    }


    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        ValidateBinarySearchTree_98 obj = new ValidateBinarySearchTree_98();
        System.out.println(obj.isValidBST(root));
    }
}
