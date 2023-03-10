// Question -> https://practice.geeksforgeeks.org/problems/96161dfced02d544fc70c71d09b7a616fe726085/1

class Solution {
    static int mod = 1000000007;
    static int[][] dp;

    public static int solve(int i, int j, int n, int m, int[][] grid) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ways = 0;
        if (j + 1 < m && grid[i][j + 1] == 1) {
            ways += solve(i, j + 1, n, m, grid);
        }

        if (i + 1 < n && grid[i + 1][j] == 1) {
            ways += solve(i + 1, j, n, m, grid);
        }

        return dp[i][j] = ways % mod;
    }

    public static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        if (grid[0][0] == 0) {
            return 0;
        }

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = solve(0, 0, n, m, grid) % mod;

        return ans;
    }
}