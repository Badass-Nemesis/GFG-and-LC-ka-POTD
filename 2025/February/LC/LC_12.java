package LC;
// Qes -> https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/ 

import java.util.*;

class Solution {
    public static int getDigitSum(int val) {
        int sum = 0;

        while (val != 0) {
            sum += val % 10;
            val /= 10;
        }

        return sum;
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;

        for (int ele : nums) {
            int digitSum = getDigitSum(ele);

            if (hm.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, ele + hm.get(digitSum));

                if (hm.get(digitSum) < ele) {
                    hm.put(digitSum, ele);
                }
            } else {
                hm.put(digitSum, ele);
            }
        }

        return ((maxSum != Integer.MIN_VALUE) ? maxSum : -1);
    }
}