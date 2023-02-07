// Question -> https://practice.geeksforgeeks.org/problems/c85e3a573a7de6dfd18398def16d05387852b319/1

class Solution {
    static Node found;

    static long sum;

    public static void traversal(Node root, int direction) {
        if (root == null) {
            return;
        }

        traversal(root.left, direction - 1);
        traversal(root.right, direction + 1);
        if (root != found && direction == 0) {
            sum += root.data;
        }
    }

    long verticallyDownBST(Node root, int target) {
        found = null;
        sum = 0;
        while (root != null) {
            if (target < root.data) {
                root = root.left;
            } else if (target > root.data) {
                root = root.right;
            } else if (target == root.data) {
                found = root;
                break;
            }
        }

        if (root == null) {
            return -1;
        }

        traversal(root, 0);
        return sum;
    }
}