// Qes -> https://www.geeksforgeeks.org/problems/inorder-traversal/1

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public static ArrayList<Integer> arr;

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        arr.add(node.data);
        dfs(node.right);
    }

    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        arr = new ArrayList<>();
        dfs(root);

        return arr;
    }
}