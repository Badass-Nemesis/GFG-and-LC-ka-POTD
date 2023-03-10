// Question -> https://practice.geeksforgeeks.org/problems/7a33c749a79327b2889d420dd80342fff33aac6d/1

class Solution {
    static int[] dpArr;

    public static int recursion(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        if (dpArr[index] != -1) {
            return dpArr[index];
        }

        int ans1 = recursion(arr, index + 1);
        int ans2 = arr[index] + recursion(arr, index + 2);
        dpArr[index] = Math.max(ans1, ans2);
        return dpArr[index];
    }

    int findMaxSum(int arr[], int n) {
        // code here
        dpArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dpArr[i] = -1;
        }

        int ans = recursion(arr, 0);
        return ans;
    }
}