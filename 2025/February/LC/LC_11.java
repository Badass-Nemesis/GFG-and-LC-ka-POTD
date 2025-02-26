package LC;
// Qes -> https://leetcode.com/problems/remove-all-occurrences-of-a-substring/ 

import java.util.*;

class Solution {
    public static void calculateLPS(String part, int n, int[] lps) {
        int i = 0, j = 1;

        while (j < n) {
            if (part.charAt(i) == part.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = lps[i - 1];
                } else {
                    j++;
                }
            }
        }
    }

    public static void removeSubstrings(StringBuilder s, String part, int[] lps) {
        int m = s.length();
        int n = part.length();
        int i = 0;
        int j = 0;

        while (i < m) {
            if (s.charAt(i) == part.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) {
                s.delete(i - n, i);
                m = s.length();
                i = Math.max(0, i - 2 * n);
                j = 0;
            }
            if (i < m && s.charAt(i) != part.charAt(j)) {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
    }

    public String removeOccurrences(String s, String part) {
        int[] lps = new int[part.length()];
        Arrays.fill(lps, 0);

        calculateLPS(part, part.length(), lps);
        StringBuilder sb = new StringBuilder(s);
        removeSubstrings(sb, part, lps);
        return sb.toString();
    }
}