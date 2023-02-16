// Question -> https://practice.geeksforgeeks.org/problems/45fa306a9116332ece4cecdaedf50f140bd252d4/1

class Solution {
    public int maxInstance(String s) {
        // Code here
        int[] freqArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqArr[s.charAt(i) - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (i == 'a' || i == 'b' - 'a') {
                ans = Math.min(ans, freqArr[i]);
            } else if (i == 'l' - 'a' || i == 'o' - 'a') {
                ans = Math.min(ans, freqArr[i] / 2);
            } else if (i == 'n' - 'a') {
                ans = Math.min(ans, freqArr[i]);
            }
        }
        return ans;
    }
}