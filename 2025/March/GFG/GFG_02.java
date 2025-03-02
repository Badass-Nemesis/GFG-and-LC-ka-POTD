// Qes -> https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

import java.util.*;

class Solution {
    public class Pair {
        int idx;
        int val;

        Pair(int val, int idx) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static ArrayDeque<Pair> putInQ(ArrayDeque<Pair> queue, Pair presentPair, int k) {
        if (queue.isEmpty()) {
            queue.add(presentPair);
            return queue;
        }

        while (!queue.isEmpty() && presentPair.val >= queue.peekLast().val) {
            queue.removeLast();
        }

        while (!queue.isEmpty() && (presentPair.idx - k) >= queue.peekFirst().idx) {
            queue.removeFirst();
        }

        queue.add(presentPair);
        return queue;
    }

    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        ArrayDeque<Pair> tempQ = new ArrayDeque<>(); // this queue will be in decreasing order
        ArrayList<Integer> ans = new ArrayList<>();

        // first putting k elements in queue
        for (int i = 0; i < k; i++) {
            tempQ = putInQ(tempQ, new Pair(arr[i], i), k);
        }
        ans.add(tempQ.peekFirst().val);

        // moving the window and adding all of the ans
        for (int i = k; i < arr.length; i++) {
            tempQ = putInQ(tempQ, new Pair(arr[i], i), k);
            ans.add(tempQ.peekFirst().val);
        }

        return ans;
    }
}