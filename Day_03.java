// Question -> https://practice.geeksforgeeks.org/problems/eae1fbd0ac8f213a833d231e26ba4d829e79dd9c/1

import java.util.*;

//Node of a linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// Linked List class
class LinkedList {
    Node head; // head of list
}

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node l1, Node l2) {
        Map<Node, Integer> map = new HashMap<>();
        Node t1 = l1;
        while (t1 != null) {
            map.put(t1, t1.data);
            t1 = t1.next;
        }
        Node t2 = l2;
        while (t2 != null) {
            if (map.containsKey(t2)) {
                return t2.data;
            }
            t2 = t2.next;
        }
        return -1;
    }
}
