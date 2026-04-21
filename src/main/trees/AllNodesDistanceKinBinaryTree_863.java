package main.trees;

import java.util.*;

public class AllNodesDistanceKinBinaryTree_863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null || k < 0) {
            return result;
        }

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int distance = 0;
        while (!queue.isEmpty()) {
            if (distance == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
                return result;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                addUnvisited(currentNode.left, queue, visited);
                addUnvisited(currentNode.right, queue, visited);
                addUnvisited(parentMap.get(currentNode), queue, visited);
            }
            distance++;
        }

        return result;
    }

    private void buildParentMap(TreeNode currentNode, TreeNode parentNode, Map<TreeNode, TreeNode> parentMap) {
        if (currentNode == null) {
            return;
        }

        if (parentNode != null) {
            parentMap.put(currentNode, parentNode);
        }

        buildParentMap(currentNode.left, currentNode, parentMap);
        buildParentMap(currentNode.right, currentNode, parentMap);
    }

    private void addUnvisited(TreeNode node, Queue<TreeNode> queue, Set<TreeNode> visited) {
        if (node != null && visited.add(node)) {
            queue.add(node);
        }
    }

    public static void main(String[] args) {
        HelperTree helperTree = new HelperTree();
        TreeNode root = helperTree.generateBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        AllNodesDistanceKinBinaryTree_863 obj = new AllNodesDistanceKinBinaryTree_863();
        System.out.println(obj.distanceK(root, root.left, 2));
    }
}
