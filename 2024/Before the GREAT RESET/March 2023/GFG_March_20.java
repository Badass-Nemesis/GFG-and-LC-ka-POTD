// Question -> https://practice.geeksforgeeks.org/problems/7366ce450d84b55391fc787a681c4d60de359e72/1

import java.util.*;

class Solution {
    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N, int M) {
        // code here
        ArrayList<Pair> arrX = new ArrayList<>();
        ArrayList<Pair> arrY = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid.get(i).get(j) == 'X') {
                    arrX.add(new Pair(i, j));
                } else if (grid.get(i).get(j) == 'Y') {
                    arrY.add(new Pair(i, j));
                }
            }
        }

        long min = Integer.MAX_VALUE;
        for (Pair xWala : arrX) {
            for (Pair yWala : arrY) {
                long temp = Math.abs(xWala.x - yWala.x) + Math.abs(xWala.y - yWala.y);
                min = Math.min(min, temp);
            }
        }

        return (int) min;
    }
}