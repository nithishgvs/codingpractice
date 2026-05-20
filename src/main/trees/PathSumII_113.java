package main.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int remainingSum, List<List<Integer>> result, List<Integer> currentList) {

        if (root == null)
            return;

        currentList.add(root.val);

        if (root.left == null && root.right == null && remainingSum == root.val) {
            result.add(new ArrayList<>(currentList));
        } else {
            helper(root.left, remainingSum - root.val, result, currentList);
            helper(root.right, remainingSum - root.val, result, currentList);
        }

        // Backtrack: remove this node so sibling paths start with the correct path.
        currentList.remove(currentList.size() - 1);
    }

    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        PathSumII_113 obj = new PathSumII_113();
        System.out.println(obj.pathSum(root, 22));
    }
}
