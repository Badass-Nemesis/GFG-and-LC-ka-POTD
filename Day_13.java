// Question -> https://practice.geeksforgeeks.org/problems/234ca3b438298fb04befd5abe7fbd98c006d4884/1

class Solution {
    public static void solve(int[][] mat, int i, int j, int[][] vis, int n, int m) {
        if (i < 0 || j < 0 || i > n || j > m || vis[i][j] == 1) {
            return;
        }

        vis[i][j] = 1;
        if (i > 0 && mat[i - 1][j] >= mat[i][j]) {
            solve(mat, i - 1, j, vis, n, m);
        }
        if (i < n - 1 && mat[i + 1][j] >= mat[i][j]) {
            solve(mat, i + 1, j, vis, n, m);
        }
        if (j > 0 && mat[i][j - 1] >= mat[i][j]) {
            solve(mat, i, j - 1, vis, n, m);
        }
        if (j < m - 1 && mat[i][j + 1] >= mat[i][j]) {
            solve(mat, i, j + 1, vis, n, m);
        }
    }

    int water_flow(int[][] mat, int N, int M) {
        // Write your code here
        int[][] indian = new int[N][M];
        int[][] arabian = new int[N][M];

        for (int i = 0; i < N; i++) {
            if (indian[i][0] == 0) {
                solve(mat, i, 0, indian, N, M);
            }
        }

        for (int j = 0; j < M; j++) {
            if (indian[0][j] == 0) {
                solve(mat, 0, j, indian, N, M);
            }
        }

        for (int i = 0; i < N; i++) {
            if (arabian[i][M - 1] == 0) {
                solve(mat, i, M - 1, arabian, N, M);
            }
        }

        for (int j = 0; j < M; j++) {
            if (arabian[N - 1][j] == 0) {
                solve(mat, N - 1, j, arabian, N, M);
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (indian[i][j] == 1 && arabian[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}