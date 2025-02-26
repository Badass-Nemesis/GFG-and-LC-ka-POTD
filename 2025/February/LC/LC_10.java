package LC;
// Qes -> https://leetcode.com/problems/clear-digits/

class Solution {
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                if (ans.length() > 0) {
                    ans.deleteCharAt(ans.length() - 1);
                }
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}