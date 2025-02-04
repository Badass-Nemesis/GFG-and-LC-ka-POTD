// Qes -> https://www.geeksforgeeks.org/problems/height-of-binary-tree/1

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public static int dfs(Node node, int count) {
        if (node.left == null && node.right == null) {
            return count;
        }

        int tempCount = 0;

        if (node.left != null) {
            tempCount = Math.max(dfs(node.left, count + 1), tempCount);
        }

        if (node.right != null) {
            tempCount = Math.max(dfs(node.right, count + 1), tempCount);
        }

        return tempCount;
    }

    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        return dfs(node, 0);
    }
}