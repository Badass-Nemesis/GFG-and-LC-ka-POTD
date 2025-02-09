// Qes -> https://leetcode.com/problems/count-number-of-bad-pairs/ 

import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        long ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            int totalPairsTillIndex = i;
            int goodPairs = hm.getOrDefault(diff, 0);

            ans += (totalPairsTillIndex - goodPairs);
            hm.put(diff, goodPairs + 1);
        }

        return ans;
    }
}