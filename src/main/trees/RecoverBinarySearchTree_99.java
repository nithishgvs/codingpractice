package main.trees;

public class RecoverBinarySearchTree_99 {


    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        previous = null;
        first = null;
        second = null;

        inorder(root);

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (previous != null && previous.val > root.val) {
            if (first == null) {
                first = previous;
            }
            second = root;
        }
        previous = root;
        inorder(root.right);
    }


    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{1, 3, null, null, 2});
        RecoverBinarySearchTree_99 obj = new RecoverBinarySearchTree_99();
        obj.recoverTree(root);
    }
}
