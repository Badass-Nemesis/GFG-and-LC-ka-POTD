package GFG;
// Qes -> https://www.geeksforgeeks.org/problems/k-sum-paths/1

import java.util.*;

class Solution {
    private int get(Node root, Map<Integer, Integer> hm, int sum, int k) {
        if (root == null) {
            return 0;
        }

        sum += root.data;
        int ans = 0;

        if (hm.containsKey(sum - k)) {
            ans += hm.get(sum - k);
        }

        hm.put(sum, hm.getOrDefault(sum, 0) + 1);

        ans += get(root.left, hm, sum, k);
        ans += get(root.right, hm, sum, k);

        hm.put(sum, hm.get(sum) - 1);

        return ans;
    }

    public int sumK(Node root, int k) {
        // code here
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        return get(root, hm, 0, k);
    }
}
