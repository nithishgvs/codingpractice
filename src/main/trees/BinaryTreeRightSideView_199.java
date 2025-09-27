package main.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                if (i == size - 1) {
                    result.add(polled.val);
                }
                if (polled.left != null)
                    queue.offer(polled.left);
                if (polled.right != null)
                    queue.offer(polled.right);
            }
        }
        return result;
    }
}
