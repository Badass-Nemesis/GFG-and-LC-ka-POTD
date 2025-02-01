// question ->
// https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1

import java.util.*;

class Solution {

    class Node {
        int data;
        Node next, random;

        Node(int d) {
            data = d;
            next = random = null;

        }
    }

    // simply making new node and then hashing original node as key with new node as
    // value and then again iterating to fillup random pointer

    // Node copyList(Node head) {
    // // your code here

    // Node curr = head;
    // Node newHead = null;
    // Node prev = null;

    // Map<Node, Node> hm = new HashMap<>();

    // // new nodes
    // while (curr != null) {
    // Node temp = new Node(curr.data);
    // hm.put(curr, temp);

    // if (newHead == null) {
    // newHead = temp;
    // } else {
    // prev.next = temp;
    // }
    // prev = temp;
    // curr = curr.next;
    // }

    // // random pointers
    // curr = head;
    // Node newCurr = newHead;
    // while (curr != null) {
    // if (curr.random == null) {
    // newCurr.random = null;
    // } else {
    // Node tempRandom = hm.get(curr.random);
    // newCurr.random = tempRandom;
    // }

    // curr = curr.next;
    // newCurr = newCurr.next;
    // }

    // return newHead;
    // }

    // inserting new node just next to/in middle of original nodes and then filling
    // up the random pointers by looking at the original node's next node (which
    // will be new node after insertion).
    Node copyList(Node head) {
        // your code here

        Node curr = head;
        Node newHead = null;

        // inserting/adding new nodes
        while (curr != null) {
            Node newNode = new Node(curr.data);
            if (newHead == null) {
                newHead = newNode;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // copying random pointers
        curr = head;
        while (curr != null) {
            if (curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // seperating new nodes from the original linkedlist
        curr = head;
        Node newCurr = head.next;
        while (curr != null && newCurr != null) {
            curr.next = curr.next == null ? null : curr.next.next;
            newCurr.next = newCurr.next == null ? null : newCurr.next.next;

            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}