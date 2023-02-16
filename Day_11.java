// Question -> https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1

class Solution {
    static int inSequence(int A, int B, int C) {
        // code here
        long temp = B - A;
        if ((A < B && C > 0) || (A > B && C < 0) || (A == B)) {
            if (C == 0 || temp % C == 0) {
                return 1;
            }
        }
        return 0;
    }
}