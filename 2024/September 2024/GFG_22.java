// question -> https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1

import java.util.*;

class Solution {
    int lps(String str) {
        // code here
        int i = 1;
        int j = 0;
        int[] lpsArr = new int[str.length()];
        Arrays.fill(lpsArr, 0);

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                j++;
                lpsArr[i] = j;
                i++;
            } else {
                if (j > 0) {
                    j = lpsArr[j - 1]; // going to previous location
                } else {
                    // no need to write this, because already filled h pura array 0 se, to agar isko
                    // ni mila previous location kuch, to ye else block mein aake directly i++ ho
                    // jayega, aur wo 0 already filled reh jayega
                    // lpsArr[i] = 0;
                    i++;
                }
            }
        }

        return lpsArr[str.length() - 1];
    }
}