package main.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateSubtrees_652 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<String> visited = new HashSet<>();
        Set<String> added = new HashSet<>();
        List<TreeNode> result = new ArrayList<>();
        helper(visited, added, root, result);
        return result;
    }

    private String helper(Set<String> visited, Set<String> added, TreeNode root, List<TreeNode> result) {
        if (root == null)
            return "NULL";

        String left = helper(visited, added, root.left, result);
        String right = helper(visited, added, root.right, result);

        String pattern = "L" + left + "|V" + root.val + "|R" + right;

        if (visited.contains(pattern) && !added.contains(pattern)) {
            result.add(root);
            added.add(pattern);
        } else
            visited.add(pattern);

        return pattern;

    }

    public static void main(String[] args) {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
        TreeNode root1 = new HelperTree().generateBinaryTree(new Integer[]{2, 2, 2, 3, null, 3, null});
        FindDuplicateSubtrees_652 obj = new FindDuplicateSubtrees_652();
        System.out.println(obj.findDuplicateSubtrees(root));
    }
}
