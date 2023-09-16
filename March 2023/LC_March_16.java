// Question -> https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

class Solution {
    public static class TreeNode {
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

    public static TreeNode solve(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = inStart;
        while (inorder[rootIndex] != postorder[postEnd]) {
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;

        root.left = solve(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        root.right = solve(inorder, postorder, rootIndex + 1, inEnd, postEnd - rightSize, postEnd - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        int inStart = 0;
        int inEnd = n - 1;

        int postStart = 0;
        int postEnd = n - 1; // root is at postEnd

        // leftSize = left partition from index of root in inorder array
        // rightSize = right partition from index of root in inorder array

        return solve(inorder, postorder, inStart, inEnd, postStart, postEnd);
    }
}