// Question -> https://practice.geeksforgeeks.org/problems/90a81c305b1fe939b9230a67824749ceaa493eab/1

class Solution {
    long[] countZero(int N, int K, int[][] arr) {
        // code here
        long[] ans = new long[K];
        int[] visited_row = new int[N];
        int[] visited_column = new int[N];
        int row_count = 0;
        int column_count = 0;

        for (int i = 0; i < K; i++) {
            int rowWala = arr[i][0] - 1;
            int columnWala = arr[i][1] - 1;

            if (visited_row[rowWala] == 0) {
                visited_row[rowWala] = 1;
                row_count++;
            }
            if (visited_column[columnWala] == 0) {
                visited_column[columnWala] = 1;
                column_count++;
            }

            ans[i] = N * N - (row_count * N) - (column_count * N) + (row_count * column_count);
        }

        return ans;
    }
}