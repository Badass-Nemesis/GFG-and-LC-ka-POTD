package LC;
// Question -> https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution {
    public boolean check(int[] nums) {
        int count = 0; // counting inversions, basically counting peaks

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                count++;
            }
        }

        // peaks can either be 0 or 1, if it's greater then the array was not in
        // increasing
        return count <= 1;
    }
}