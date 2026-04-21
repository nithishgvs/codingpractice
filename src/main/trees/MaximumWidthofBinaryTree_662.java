package main.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumWidthofBinaryTree_662 {

    class Node {
        TreeNode treeNode;
        long index;

        public Node(TreeNode treeNode, long index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = 0;

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(root, 0));

        while (!deque.isEmpty()) {
            long leftMost = deque.peekFirst().index;
            long rightMost = deque.peekLast().index;
            max = Math.max(max, (int) (rightMost - leftMost + 1));

            int size = deque.size();

            for (int i = 0; i < size; i++) {

                Node node = deque.poll();
                long normalizedIndex = node.index - leftMost;

                if (node.treeNode.left != null)
                    deque.add(new Node(node.treeNode.left, 2 * normalizedIndex));

                if (node.treeNode.right != null)
                    deque.add(new Node(node.treeNode.right, 2 * normalizedIndex + 1));

            }
        }


        return max;
    }

    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{1, 3, 2, 5, 3, null, 9});
        MaximumWidthofBinaryTree_662 obj = new MaximumWidthofBinaryTree_662();
        System.out.println(obj.widthOfBinaryTree(root));
    }
}
