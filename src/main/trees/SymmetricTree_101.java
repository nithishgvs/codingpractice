package main.trees;

public class SymmetricTree_101 {


    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        return helper(root.left, root.right);

    }

    private boolean helper(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        return (left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left);

    }

    public static void main(String[] args) {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        SymmetricTree_101 symmetricTree101 = new SymmetricTree_101();
        System.out.println(symmetricTree101.isSymmetric(root));
    }
}
