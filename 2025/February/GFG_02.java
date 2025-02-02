// Qes -> https://www.geeksforgeeks.org/problems/level-order-traversal/1

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
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> tempQueue = new ArrayDeque<>();
        tempQueue.add(root);

        while (!tempQueue.isEmpty()) {
            int levelSize = tempQueue.size();
            ArrayList<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node tempNode = tempQueue.poll();
                levelList.add(tempNode.data);

                if (tempNode.left != null) {
                    tempQueue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    tempQueue.add(tempNode.right);
                }
            }

            ans.add(levelList);
        }

        return ans;
    }
}
