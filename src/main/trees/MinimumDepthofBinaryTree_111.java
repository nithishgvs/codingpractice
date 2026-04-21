package main.trees;

public class MinimumDepthofBinaryTree_111 {


    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int right = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
        return 1 + Math.min(left, right);
    }

    static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6});
        MinimumDepthofBinaryTree_111 obj = new MinimumDepthofBinaryTree_111();
        System.out.println(obj.minDepth(root));
    }
}
