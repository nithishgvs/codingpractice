package main.trees;

public class SumRoottoLeafNumbers_129 {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currentNumber) {
        if (root == null)
            return 0;

        currentNumber = currentNumber * 10 + root.val;
        if (root.left == null && root.right == null)
            return currentNumber;

        return helper(root.left, currentNumber) + helper(root.right, currentNumber);
    }

    public static void main(String[] args) {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{4, 9, 0, 5, 1});
        SumRoottoLeafNumbers_129 obj = new SumRoottoLeafNumbers_129();
        System.out.println(obj.sumNumbers(root));

    }
}
