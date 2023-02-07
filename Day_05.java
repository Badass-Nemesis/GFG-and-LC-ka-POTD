// Question -> https://practice.geeksforgeeks.org/problems/4dfa8ba14d4c94f4d7637b6b5246782412f3aeb8/1

class Solution {
    /*
     * Function to return the length of the
     * longest subarray with positive product
     */
    int maxLength(int arr[], int n) {
        // code here
        int ans = 0;
        int sum = 1;

        for (int i = 0, j = 0; j < arr.length; j++) {
            sum *= arr[j];

            while (i < arr.length && sum <= 0) {
                sum /= arr[i];
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}