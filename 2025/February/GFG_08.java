// Qes -> https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

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
    private ArrayList<Integer> boundaryTraversal;

    private void leftBoundary(Node root) {
        Node leftNode = root.left;
        if (leftNode == null) {
            return;
        }

        while (!isLeafNode(leftNode)) {
            boundaryTraversal.add(leftNode.data);
            if (leftNode.left != null) {
                leftNode = leftNode.left;
            } else {
                leftNode = leftNode.right;
            }
        }
    }

    private void rightBoundary(Node root) {
        Deque<Integer> stack = new ArrayDeque<>(); // queue wala stack, lol
        Node rightNode = root.right;
        if (rightNode == null) {
            return;
        }

        while (!isLeafNode(rightNode)) {
            stack.push(rightNode.data);
            if (rightNode.right != null) {
                rightNode = rightNode.right;
            } else {
                rightNode = rightNode.left;
            }
        }

        while (!stack.isEmpty()) {
            boundaryTraversal.add(stack.pop());
        }
    }

    private void leafNodes(Node node) {
        if (node == null) {
            return;
        }

        if (isLeafNode(node)) {
            boundaryTraversal.add(node.data);
        }

        leafNodes(node.left);
        leafNodes(node.right);
    }

    private Boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        boundaryTraversal = new ArrayList<>();

        if (!isLeafNode(root)) {
            boundaryTraversal.add(root.data);
        }

        leftBoundary(root);
        leafNodes(root);
        rightBoundary(root);

        return boundaryTraversal;
    }
}