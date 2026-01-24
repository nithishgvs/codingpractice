package main.trees;

public class KthSmallestElementinaBST_230 {


    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        result = -1;
        inOrder(root);
        return result;
    }


    public void inOrder(TreeNode root) {
        if (root == null || count == 0)
            return;
        inOrder(root.left);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{3, 1, 4, null, 2});
        KthSmallestElementinaBST_230 obj = new KthSmallestElementinaBST_230();
        obj.inOrder(root);
        obj.kthSmallest(root, 3);
    }
}
