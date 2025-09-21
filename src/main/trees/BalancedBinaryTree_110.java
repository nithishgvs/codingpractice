package main.trees;

public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        int left = height(node.left);
        if (left == -1)
            return -1;
        int right = height(node.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        BalancedBinaryTree_110 balancedBinaryTree110 = new BalancedBinaryTree_110();
        System.out.println(balancedBinaryTree110.isBalanced(treeNode));
    }

}
