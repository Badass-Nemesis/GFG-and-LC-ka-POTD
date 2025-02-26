// Qes -> https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

// This is my approach

// class Solution {
//     public int maxAbsoluteSum(int[] nums) {
//         int originalSum = Integer.MIN_VALUE;
//         int reversedSum = Integer.MIN_VALUE;

//         int tempSum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             tempSum += nums[i];

//             if (tempSum < 0) {
//                 tempSum = 0;
//             }
//             originalSum = Math.max(tempSum, originalSum);
//         }

//         tempSum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             tempSum += (-1 * nums[i]); // reversing the sign and then adding

//             if (tempSum < 0) {
//                 tempSum = 0;
//             }
//             reversedSum = Math.max(tempSum, reversedSum);
//         }

//         return Math.max(reversedSum, originalSum);
//     }
// }

// This is somewhat more optimal, this is Kadane's Algo
// lol this took 7ms, while my 2 loop reverse sign code took 2ms

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currMaxSubarrSum = nums[0];
        int maxSubarrSum = nums[0];

        int currMinSubarrSum = nums[0];
        int minSubarrSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMaxSubarrSum = Math.max(nums[i], currMaxSubarrSum + nums[i]);
            maxSubarrSum = Math.max(currMaxSubarrSum, maxSubarrSum);

            currMinSubarrSum = Math.min(nums[i], currMinSubarrSum + nums[i]);
            minSubarrSum = Math.min(currMinSubarrSum, minSubarrSum);
        }

        return Math.max(maxSubarrSum, Math.abs(minSubarrSum));
    }
}