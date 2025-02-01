// Question -> https://practice.geeksforgeeks.org/problems/38f100615d0b2efa755e7b07f905e0f8cd2fe5df/1

class Solution {
    public static int appleSequence(int n, int m, String arr) {
        // code here
        int ans = Integer.MIN_VALUE;
        int k = m;
        for (int i = 0, j = 0; j < arr.length(); j++) {
            if (arr.charAt(i) == 'O') {
                k--;
            }

            while (k < 0) {
                if (arr.charAt(i) == 'O') {
                    k++;
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}