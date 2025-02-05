// Qes -> https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal 

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        char temp1 = 'a';
        char temp2 = 'a';
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count == 1) {
                    temp1 = s1.charAt(i);
                    temp2 = s2.charAt(i);
                } else if (count == 2) {
                    if (temp1 == s2.charAt(i) && temp2 == s1.charAt(i)) {
                        // then it's ok
                    } else {
                        return false;
                    }
                }

            }
        }

        return (count == 2);
    }
}