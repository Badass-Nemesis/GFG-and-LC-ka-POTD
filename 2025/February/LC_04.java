// Qes -> https://leetcode.com/problems/maximum-ascending-subarray-sum 

class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int tempSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                tempSum += nums[i];
            } else if (nums[i - 1] >= nums[i]) {
                maxSum = Math.max(maxSum, tempSum);
                tempSum = nums[i];
            }
        }

        return Math.max(maxSum, tempSum);
    }
}