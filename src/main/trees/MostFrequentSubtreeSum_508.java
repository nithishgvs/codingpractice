package main.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum_508 {

    private int maxFreq = 0;
    private final Map<Integer, Integer> frequency = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        helper(root);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxFreq)
                result.add(entry.getKey());
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        int rootSum = left + right + root.val;
        int count = frequency.getOrDefault(rootSum, 0) + 1;
        maxFreq = Math.max(maxFreq, count);
        frequency.put(rootSum, count);
        return rootSum;

    }

    public static void main(String[] args) {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{5, 2, -3});
        MostFrequentSubtreeSum_508 obj = new MostFrequentSubtreeSum_508();
        System.out.println(Arrays.toString(obj.findFrequentTreeSum(root)));
    }
}
