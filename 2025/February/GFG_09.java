// Qes -> https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1 

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    // Function to return maximum path sum from any node in a tree.
    public static int max;

    public static int path(Node root) {
        if (root == null) {
            return 0;
        }

        int l = Math.max(0, path(root.left));
        int r = Math.max(0, path(root.right));

        max = Math.max(max, root.data + l + r);
        return (root.data + Math.max(l, r));
    }

    int findMaxSum(Node node) {
        // your code goes here
        max = Integer.MIN_VALUE;
        path(node);

        return max;
    }
}