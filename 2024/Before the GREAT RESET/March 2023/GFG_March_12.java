// Question -> https://practice.geeksforgeeks.org/problems/77e1c3e12cd148f835d53eb168d4472b2ff539fa/1

class Solution {
    public int[] findMaxRow(int mat[][], int N) {
        // code here
        int i = 0;
        int j = N - 1;

        int row = 0;
        int one_count = 0;
        while (j >= 0 && i < N) {
            if (mat[i][j] == 1) {
                one_count++;
                row = i;
                j--;
            } else {
                i++;
            }
        }

        int[] ans = new int[2];
        ans[0] = row;
        ans[1] = one_count;

        return ans;
    }
}