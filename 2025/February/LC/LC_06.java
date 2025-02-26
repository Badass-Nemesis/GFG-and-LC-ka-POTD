package LC;
// Qes -> https://leetcode.com/problems/tuple-with-same-product/

import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> products = new HashMap<>();

        // using brute-force basically
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int res = nums[i] * nums[j];
                products.put(res, products.getOrDefault(res, 0) + 1);
            }
        }

        int ans = 0;
        for (int key : products.keySet()) {
            int appearCount = products.get(key);

            if (appearCount >= 2) {
                int temp = (appearCount * (appearCount - 1)) / 2;
                ans += temp * 8;
            }
        }

        return ans;
    }
}