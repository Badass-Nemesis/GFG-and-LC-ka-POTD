package GFG;
// Qes -> https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    public static ArrayList<Integer> nodes;

    public void dfs(Node root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        nodes.add(root.data);
        dfs(root.right);
    }

    public int kthSmallest(Node root, int k) {
        nodes = new ArrayList<>();
        dfs(root);

        if (k > 0 && k <= nodes.size()) {
            return nodes.get(k - 1);
        }

        return -1;
    }
}