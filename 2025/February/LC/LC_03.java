package LC;
// Qes ->
// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/

/* ------- THIS IS MY DUMB SOLUTION ---------- */

// class Solution {
// public int longestMonotonicSubarray(int[] nums) {
// if (nums.length == 1) {
// return 1;
// }

// int maxCount = 0;

// for (int i = 1; i < nums.length; i++) {
// int tempCount = 0;

// if (nums[i - 1] < nums[i]) {
// // increasing case
// while (i < nums.length && nums[i - 1] < nums[i]) {
// tempCount++;
// i++;
// }
// maxCount = Math.max(tempCount, maxCount);
// } else if (nums[i - 1] > nums[i]) {
// // decreasing case
// while (i < nums.length && nums[i - 1] > nums[i]) {
// tempCount++;
// i++;
// }
// maxCount = Math.max(tempCount, maxCount);
// }

// if (tempCount > 0) {
// i--;
// }
// }

// return maxCount + 1;
// }
// }

/* -------- IMPROVED SOLUTION --------- */

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int maxCount = 0;
        int increasingCount = 0;
        int decreasingCount = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                increasingCount++;
                decreasingCount = 0;
            } else if (nums[i - 1] > nums[i]) {
                decreasingCount++;
                increasingCount = 0;
            } else {
                increasingCount = 0;
                decreasingCount = 0;
            }

            maxCount = Math.max(maxCount, Math.max(increasingCount, decreasingCount));
        }

        return maxCount + 1; // adding 1 because default case is 1, but I took it 0
    }
}