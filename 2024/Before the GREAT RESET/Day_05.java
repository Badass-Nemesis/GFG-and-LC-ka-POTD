// Question -> https://practice.geeksforgeeks.org/problems/4dfa8ba14d4c94f4d7637b6b5246782412f3aeb8/1

class Solution {
    /*
     * Function to return the length of the
     * longest subarray with positive product
     */
    int maxLength(int arr[], int n) {
        // code here
        int positive = 0;
        int negative = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                positive++;
                if (negative > 0) {
                    negative++;
                }
            } else if (arr[i] < 0) {
                if (negative > 0) {
                    int temp = positive;
                    positive = negative + 1;
                    negative = temp + 1;
                } else if (negative == 0) {
                    negative = positive + 1;
                    positive = 0;
                }
            } else if (arr[i] == 0) {
                negative = 0;
                positive = 0;
            }
            ans = Math.max(ans, positive);
        }

        return ans;
    }
}