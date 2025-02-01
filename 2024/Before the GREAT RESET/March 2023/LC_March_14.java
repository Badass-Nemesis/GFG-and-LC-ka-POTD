// Question -> https://leetcode.com/problems/sum-root-to-leaf-numbers/

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumNumbers(TreeNode root) {
        int currentSum = 0;
        return sumNodes(root, currentSum);
    }

    public int sumNodes(TreeNode root, int currentSum) {
        if (root == null)
            return 0;
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null)
            return currentSum;

        int leftSum = sumNodes(root.left, currentSum);
        int rightSum = sumNodes(root.right, currentSum);
        return leftSum + rightSum;
    }
}