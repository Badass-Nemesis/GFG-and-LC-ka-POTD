// Qes -> https://www.geeksforgeeks.org/problems/construct-tree-1/1

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Solution {
    public static Node split(int[] inorder, int inorderStart, int inorderEnd, int[] preorder, int index,
            HashMap<Integer, Integer> hm) {
        Node root = new Node(preorder[index]);
        int mid = hm.get(root.data);

        if (mid > inorderStart) {
            root.left = split(inorder, inorderStart, mid - 1, preorder, index + 1, hm);
        }

        if (mid < inorderEnd) {
            root.right = split(inorder, mid + 1, inorderEnd, preorder, index + mid - inorderStart + 1, hm);
        }

        return root;
    }

    public static Node buildTree(int inorder[], int preorder[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return split(inorder, 0, inorder.length - 1, preorder, 0, hm);
    }
}