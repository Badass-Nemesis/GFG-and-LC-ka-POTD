package LC;
// Qes -> https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/

import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colourFreq = new HashMap<>();
        Map<Integer, Integer> ballColour = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; ++i) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColour.containsKey(ball)) {
                int prevColor = ballColour.get(ball);
                colourFreq.put(prevColor, colourFreq.get(prevColor) - 1);
                if (colourFreq.get(prevColor) == 0) {
                    colourFreq.remove(prevColor);
                }
            }

            colourFreq.put(color, colourFreq.getOrDefault(color, 0) + 1);
            ballColour.put(ball, color);

            ans.add(colourFreq.size());
        }

        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }

        return ansArr;
    }
}