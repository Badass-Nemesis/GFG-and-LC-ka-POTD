// Question -> https://practice.geeksforgeeks.org/problems/2e068e2342b9c9f40cfda1ed8e8119542d748fd8/1

class Solution {
    static int[] endPoints(int[][] matrix, int R, int C) {
        // code here
        int[] rows = { 0, 1, 0, -1 };
        int[] colums = { 1, 0, -1, 0 };
        // right, down, left, up

        int i = 0;
        int j = 0;
        int direction = 0; // 0,1,2,3 -> right, down, left, up
        while (i >= 0 && i < R && j >= 0 && j < C) {
            if (matrix[i][j] == 0) {
                // do nothing
            } else {
                direction++;
                matrix[i][j] = 0;
            }
            direction %= 4;
            i += rows[direction];
            j += colums[direction];
        }

        if (i < 0) {
            i++;
        } else if (i == R) {
            i--;
        }

        if (j < 0) {
            j++;
        } else if (j == C) {
            j--;
        }
        int[] ans = { i, j };
        return ans;
    }

    // someone's code from youtube
    static int[] endPoints2(int[][] arr, int m, int n) {
        int i = 0;
        int j = 0;
        int curr_dir = 1;
        int curr_i = 0;
        int curr_j = 0;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (i >= 0 && i < m && j >= 0 && j < n) {
            curr_i = i;
            curr_j = j;

            if (arr[i][j] == 0) {
                i += dx[curr_dir];
                j += dy[curr_dir];
            } else {
                curr_dir = (curr_dir + 1) % 4;
                arr[i][j] = 0;
                i += dx[curr_dir];
                j += dy[curr_dir];
            }
        }

        int[] ans = new int[] { curr_i, curr_j };
        return ans;
    }
}