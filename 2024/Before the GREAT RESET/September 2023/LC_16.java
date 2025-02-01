// Question -> https://leetcode.com/problems/path-with-minimum-effort/?envType=daily-question&envId=2023-09-16

import java.util.*;
// import java.io.*;

class Solution {
    public static class Pair implements Comparable<Pair> {
        int diff;
        int col;
        int row;

        Pair(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Pair other) {
            return this.diff - other.diff;
        }
    }

    public static int[] dir1 = { -1, 0, 1, 0 };
    public static int[] dir2 = { 0, -1, 0, 1 };

    public int minimumEffortPath(int[][] heights) {
        Queue<Pair> pq = new PriorityQueue<>();
        int m = heights.length;
        int n = heights[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        res[0][0] = 0;

        pq.add(new Pair(0, 0, 0));
        while (pq.size() > 0) {
            Pair temp = pq.poll();

            int tempRow = temp.row;
            int tempCol = temp.col;

            for (int i = 0; i < 4; i++) {
                int newRow = tempRow + dir1[i];
                int newCol = tempCol + dir2[i];

                if (newRow < m && newRow >= 0 && newCol < n && newCol >= 0) {
                    int diffMax = Math.max(temp.diff, Math.abs(heights[newRow][newCol] - heights[tempRow][tempCol]));

                    // This will give TLE
                    // res[newRow][newCol] = Math.min(res[newRow][newCol], diffMax);
                    // pq.add(new Pair(diffMax, newRow, newCol));

                    if (res[newRow][newCol] > diffMax) {
                        res[newRow][newCol] = diffMax;
                        pq.add(new Pair(diffMax, newRow, newCol));
                    }
                }
            }

        }

        return res[m - 1][n - 1];
    }
}