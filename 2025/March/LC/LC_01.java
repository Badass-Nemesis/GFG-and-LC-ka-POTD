// Qes -> https://leetcode.com/problems/apply-operations-to-an-array/description/ 

class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int i = 0;
        int j = 0;

        while (i < nums.length && j < nums.length) {
            if (nums[i] != 0 && nums[j] != 0) {
                i++;
                j++;
            } else {
                // find non zero number
                while (i < nums.length && nums[i] == 0) {
                    i++;
                }

                // swap if found non-zero
                if (i < nums.length) {
                    nums[j] = nums[i];
                    nums[i] = 0;

                    i++;
                    j++;
                }
            }
        }

        return nums;
    }
}