class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.abs(nums[i - 1] - nums[i]);
            if (temp % 2 == 0) {
                return false;
            }
        }

        return true;
    }
}