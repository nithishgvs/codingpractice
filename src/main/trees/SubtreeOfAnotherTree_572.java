package main.trees;

public class SubtreeOfAnotherTree_572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }


    public static void main(String[] args) {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{3, 4, 5, 1, 2});
        TreeNode root2 = new HelperTree().generateBinaryTree(new Integer[]{4, 1, 2});
        SubtreeOfAnotherTree_572 obj = new SubtreeOfAnotherTree_572();
        System.out.println(obj.isSubtree(root, root2));
    }
}
