// Question -> https://practice.geeksforgeeks.org/problems/9a88fe7ada1c49c2b3da7a67b43875e4a76aface/1

import java.util.*;

class Solution {
    static int[] matching;
    static int[] visited;

    public boolean recursion(int person, int[][] G) {
        for (int job = 0; job < G[0].length; job++) {
            if (G[person][job] == 1 && visited[job] == 0) {
                visited[job] = 1;
                if (matching[job] == -1 || recursion(matching[job], G) == true) {
                    matching[job] = person;
                    return true;
                }
            }
        }

        return false;
    }

    public int maximumMatch(int[][] G) {
        int persons = G.length;
        int jobs = G[0].length;
        int ans = 0;

        matching = new int[jobs];
        Arrays.fill(matching, -1);

        for (int i = 0; i < persons; i++) {
            visited = new int[jobs];
            Arrays.fill(visited, 0);

            if (recursion(i, G) == true) {
                ans++;
            }
        }

        return ans;
    }
}