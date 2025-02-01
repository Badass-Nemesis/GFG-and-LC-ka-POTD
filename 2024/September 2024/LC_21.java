// question -> https://leetcode.com/problems/lexicographical-numbers/description/

import java.util.*;

class Solution {
    public static List<Integer> ans;

    public static void recursion(int i, int n) {
        if (i > n)
            return;

        ans.add(i);
        for (int j = 0; j < 10; j++) {
            recursion(i * 10 + j, n);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            recursion(i, n);
        }
        return ans;
    }
}