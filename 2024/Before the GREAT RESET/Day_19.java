// Question -> https://practice.geeksforgeeks.org/problems/2145720aebf8ea0b07f76b17217b3353a0fbea7f/1

// import java.util.*;

class Solution {

    // THIS IS AC CODE
    public static int minIteration(int N, int M, int x, int y) {
        // code here
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                ans = Math.max(ans, Math.abs(i - x) + Math.abs(j - y));
            }
        }

        return ans;
    }

    // THIS BFS IS GIVING WA
    // public static class Pair {
    // int x;
    // int y;

    // Pair(int x, int y) {
    // this.x = x;
    // this.y = y;
    // }
    // }

    // public static int minIteration(int N, int M, int x, int y) {
    // // code here
    // int[][] mat = new int[N][M];
    // mat[x - 1][y - 1] = 1;

    // Queue<Pair> queue = new ArrayDeque<>();
    // queue.add(new Pair(x - 1, y - 1));

    // int iterations = 0;
    // while (queue.size() != 0) {
    // iterations++;

    // for (int i = 0; i < queue.size(); i++) {
    // Pair curr = queue.remove();
    // // System.out.println(curr.x + " " + curr.y); // debug

    // // LEFT
    // if (curr.x > 0 && mat[curr.x - 1][curr.y] == 0) {
    // queue.add(new Pair(curr.x - 1, curr.y));
    // mat[curr.x - 1][curr.y] = 1;
    // }

    // // RIGHT
    // if (curr.x < N - 1 && mat[curr.x + 1][curr.y] == 0) {
    // queue.add(new Pair(curr.x + 1, curr.y));
    // mat[curr.x + 1][curr.y] = 1;
    // }

    // // TOP
    // if (curr.y > 0 && mat[curr.x][curr.y - 1] == 0) {
    // queue.add(new Pair(curr.x, curr.y - 1));
    // mat[curr.x][curr.y - 1] = 1;
    // }

    // // DOWN
    // if (curr.y < M - 1 && mat[curr.x][curr.y + 1] == 0) {
    // queue.add(new Pair(curr.x, curr.y + 1));
    // mat[curr.x][curr.y + 1] = 1;
    // }
    // }
    // }

    // for (int i = 0; i < N; i++) {
    // for (int j = 0; j < M; j++) {
    // if (mat[i][j] == 0) {
    // System.out.println(i + " " + j);
    // }
    // }
    // }

    // return iterations - 1;
    // }
}