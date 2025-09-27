package main.trees;

public class CountCompleteTreeNodes_222 {

    public int countNodes(TreeNode root) {

        if (root == null)
            return 0;

        //Root node case
        if (root.left == null && root.right == null)
            return 1;

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6});
        CountCompleteTreeNodes_222 object = new CountCompleteTreeNodes_222();
        System.out.println(object.countNodes(root));
    }

}
