// Question -> https://practice.geeksforgeeks.org/problems/d54c71dc974b7db3a200eb63f34e3d1cba955d86/1

// import java.util.*;

class Solution {
    Long maxTripletProduct(Long arr[], int n) {
        // Complete the function

        // Time complexity is N(logN)
        // Arrays.sort(arr);

        // long product1 = arr[n - 1] * arr[n - 2] * arr[n - 3];
        // long product2 = arr[0] * arr[1] * arr[n - 1];

        // return Math.max(product1, product2);

        // Time complexity is N
        long pos1 = Integer.MIN_VALUE;
        long pos2 = Integer.MIN_VALUE;
        long pos3 = Integer.MIN_VALUE;
        long neg1 = Integer.MAX_VALUE;
        long neg2 = Integer.MAX_VALUE;

        for (Long val : arr) {
            if (pos1 < val) {
                pos3 = pos2;
                pos2 = pos1;
                pos1 = val;
            } else if (pos2 < val) {
                pos3 = pos2;
                pos2 = val;
            } else if (pos3 < val) {
                pos3 = val;
            }

            if (neg1 > val) {
                neg2 = neg1;
                neg1 = val;
            } else if (neg2 > val) {
                neg2 = val;
            }
        }

        return Math.max(pos1 * pos2 * pos3, neg1 * neg2 * pos1);
    }
}