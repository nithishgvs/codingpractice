package main.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, new StringBuilder(), result);
        return result;
    }

    private void helper(TreeNode root, StringBuilder currentList, List<String> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            currentList.append(root.val);
            result.add(currentList.toString());
            return;
        }

        currentList.append(root.val).append("->");
        helper(root.left, new StringBuilder(currentList), result);
        helper(root.right, new StringBuilder(currentList), result);
    }

    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{1, 2, 3, null, 5});
        BinaryTreePaths_257 obj = new BinaryTreePaths_257();
        System.out.println(obj.binaryTreePaths(root));
    }
}
