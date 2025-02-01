// Question -> https://practice.geeksforgeeks.org/problems/a6528c893d4ab645ec6e0690c7982748385099c8/1

class Solution {
    int[] updateQuery(int N, int Q, int[][] U) {
        // Write your code here
        int[][] prefix = new int[N + 1][32];
        int[] ans = new int[N];

        for (int i = 0; i < Q; i++) {
            int l = U[i][0];
            int r = U[i][1];
            int x = U[i][2];
            int pos = 0;
            while (x > 0) {
                if ((x & 1) != 0) {
                    prefix[l - 1][pos]++;
                    prefix[r][pos]--;
                }
                pos++;
                x /= 2;
            }
        }

        for (int i = 0; i < 32; i++) {
            for (int j = 1; j < N; j++) {
                prefix[j][i] += prefix[j - 1][i];
            }
        }

        for (int i = 0; i < N; i++) {
            int res = 0;
            for (int j = 0; j < 20; j++) {
                if (prefix[i][j] > 0) {
                    res += (1 << j);
                }
            }
            ans[i] = res;
        }

        return ans;
    }
}