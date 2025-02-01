// Question -> https://practice.geeksforgeeks.org/problems/6c4053871794c5e7a0817d7eaf88d71c4bb4c2bc/1

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
    static Node prev;
    static Node first;
    static Node second;

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    public Node correctBST(Node root) {
        // code here.
        prev = null;
        first = null;
        second = null;
        inorder(root);
        int a = first.data;
        int b = second.data;
        first.data = b;
        second.data = a;

        return root;
    }
}
