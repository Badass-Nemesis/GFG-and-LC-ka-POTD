// Question -> https://practice.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1

// import java.util.*;
// import java.io.*;

class Solution {
    // Function to count the number of ways in which frog can reach the top.
    public static long mod = 1000000007;

    static long countWays(int n) {

        long a = 1, b = 2, c = 4;

        if (n == 1)
            return a;
        if (n == 2)
            return b;
        if (n == 3)
            return c;

        long d = 0;

        for (int i = 4; i <= n; i++) {
            d = (((a % mod + b % mod) % mod + c % mod) % mod);
            a = b % mod;
            b = c % mod;
            c = d % mod;
        }

        return d % mod;
    }
}
