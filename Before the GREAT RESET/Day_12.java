// Question -> https://practice.geeksforgeeks.org/problems/51b266505221b97522b1d2c86ddad1868a54831b/1

class Solution {
    static int[][] dpArr;

    public static int recursion(int previousColor, int[][] colors, int index) {
        if (index < 0) {
            return 0;
        }

        if (dpArr[index][previousColor] != -1) {
            return dpArr[index][previousColor];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (previousColor != i) {
                ans = Math.min(recursion(i, colors, index - 1) + colors[index][i], ans);
            }
        }
        dpArr[index][previousColor] = ans;

        return ans;
    }

    int minCost(int[][] colors, int N) {
        // Write your code here
        dpArr = new int[N + 1][4];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < 4; j++) {
                dpArr[i][j] = -1;
            }
        }
        int ans = recursion(0, colors, N - 2) + colors[N - 1][0];
        ans = Math.min(recursion(1, colors, N - 2) + colors[N - 1][1], ans);
        ans = Math.min(recursion(2, colors, N - 2) + colors[N - 1][2], ans);

        return ans;
    }
}