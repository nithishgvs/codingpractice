package main.trees;

public class DeleteNodeinaBST_450 {
    /*
     * Memory hook:
     * 1. Use BST property to find the node.
     *    key < root.val -> go left
     *    key > root.val -> go right
     * 2. When the node is found, handle 3 cases:
     *    no left child  -> return right
     *    no right child -> return left
     *    two children   -> copy inorder successor (min of right subtree),
     *                      then delete that successor from the right subtree
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            // Case 1: no left child, so the right child replaces this node.
            if (root.left == null) {
                return root.right;
            }

            // Case 2: no right child, so the left child replaces this node.
            if (root.right == null) {
                return root.left;
            }

            // Case 3: two children.
            // Replace this node with the inorder successor:
            // the smallest value in the right subtree.
            TreeNode successor = findMin(root.right);
            root.val = successor.val;

            // Delete the duplicate successor node from the right subtree.
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        DeleteNodeinaBST_450 solution = new DeleteNodeinaBST_450();
        TreeNode updatedRoot = solution.deleteNode(root, 3);
        solution.printInOrder(updatedRoot);
    }

    private void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
