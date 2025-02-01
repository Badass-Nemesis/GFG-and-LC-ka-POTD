// Question -> https://practice.geeksforgeeks.org/problems/f4d22b1f9d62e8bee0ff84e9fa51dc66eb5005ec/1

class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        // code here
        int count = 0;
        StringBuilder s = new StringBuilder(S);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        for (int i = 0; i < N; i++) {
            int tempIndex = P[i];
            if (tempIndex > 0 && s.charAt(tempIndex) == s.charAt(tempIndex - 1)) {
                count--;
            }
            if (tempIndex < N - 1 && s.charAt(tempIndex) == s.charAt(tempIndex + 1)) {
                count--;
            }

            if (count == 0) {
                return (i + 1);
            }

            s.setCharAt(tempIndex, '?');
        }

        return N;
    }
}
