// Question -> https://practice.geeksforgeeks.org/problems/202d95ecdeec659401edc63dd952b1d37b989ab8/1

import java.util.*;

class Solution {
    static long solve(int N, int K, ArrayList<Long> GeekNum) {
        // code here
        long next_term = 0;
        for (int i = 0; i < K; i++) {
            if (i == N - 1) {
                return GeekNum.get(i);
            }
            next_term += GeekNum.get(i);
        }
        GeekNum.add(next_term);

        int i = 0;
        int j = K;

        while (j != N) {
            next_term -= GeekNum.get(i);
            next_term += GeekNum.get(j);
            GeekNum.add(next_term);
            i++;
            j++;
        }

        return GeekNum.get(N - 1);
    }
}