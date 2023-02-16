// Question -> https://practice.geeksforgeeks.org/problems/6cb0782855c0f11445b8d70e220f888e6ea8e22a/1

import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Solution {
    static boolean[] primes;
    static int limit = (int) 1e5;

    public static void sieve() {
        primes = new boolean[limit];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        primes[2] = true;
        for (int i = 2; i < limit; i++) {
            if (primes[i] == true) {
                for (int j = i + i; j < limit; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    Node primeList(Node head) {
        // code here
        sieve();
        Node tempHead = head;
        while (head != null) {
            int temp = head.val;
            if (primes[temp] == true) {
                // do nothing
            } else {
                int leftWala = temp;
                int rightWala = temp;
                while (leftWala >= 0 && primes[leftWala] == false) {
                    leftWala--;
                }
                while (rightWala < limit && primes[rightWala] == false) {
                    rightWala++;
                }

                if (leftWala >= 0 && primes[leftWala] == true
                        && Math.abs(leftWala - temp) <= Math.abs(rightWala - temp)) {
                    head.val = leftWala;
                } else if (rightWala < limit && primes[rightWala] == true
                        && Math.abs(leftWala - temp) > Math.abs(rightWala - temp)) {
                    head.val = rightWala;
                }
            }

            head = head.next;
        }

        return tempHead;
    }
}