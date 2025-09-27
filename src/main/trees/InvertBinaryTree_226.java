package main.trees;

public class InvertBinaryTree_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        InvertBinaryTree_226 invertBinaryTree226 = new InvertBinaryTree_226();
        TreeNode inverted = invertBinaryTree226.invertTree(root);
        System.out.println(inverted);
    }
}
