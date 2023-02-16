// Question -> https://practice.geeksforgeeks.org/problems/e2d156755ca4e0a9b9abf5680191d4b06e52b1a8/1

import java.util.*;

class Solution {
    static int[] vis;

    public static int solve(int[] arr, int i) {
        if (i >= arr.length || i < 0) {
            return 1;
        }

        if (vis[i] != -1) {
            return vis[i];
        }
        vis[i] = 0;
        vis[i] = solve(arr, i + arr[i]);

        return vis[i];
    }

    public static int goodStones(int n, int[] arr) {
        // code here
        vis = new int[n];
        Arrays.fill(vis, -1);
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                solve(arr, i);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 1) {
                count++;
            }
        }

        return count;
    }
}
