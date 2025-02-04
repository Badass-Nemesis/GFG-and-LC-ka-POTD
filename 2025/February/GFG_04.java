// Qes -> https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1 

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public static int maxDiameter;

    public static int dfs(Node node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);

        return (Math.max(left, right) + 1);
    }

    int diameter(Node root) {
        // Your code here
        maxDiameter = Integer.MIN_VALUE;
        dfs(root);

        return maxDiameter;
    }
}