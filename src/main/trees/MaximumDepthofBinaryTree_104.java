package main.trees;

public class MaximumDepthofBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left = root.left != null ? maxDepth(root.left) : Integer.MIN_VALUE;
        int right = root.right != null ? maxDepth(root.right) : Integer.MIN_VALUE;
        return 1 + Math.max(left, right);
    }

    static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        MaximumDepthofBinaryTree_104 obj = new MaximumDepthofBinaryTree_104();
        System.out.println(obj.maxDepth(root));
    }
}
