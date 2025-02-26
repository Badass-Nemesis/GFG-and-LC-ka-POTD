package GFG;
// Qes -> https://www.geeksforgeeks.org/problems/check-for-bst/1

import java.util.*;

class Solution {
    public static ArrayList<Integer> ans;

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        ans.add(root.data);
        inorder(root.right);
    }

    boolean isBST(Node root) {
        ans = new ArrayList<>();
        inorder(root);

        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i) <= ans.get(i - 1)) {
                return false;
            }
        }

        return true;
    }
}