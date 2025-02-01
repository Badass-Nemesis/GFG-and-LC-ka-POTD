class Solution {
    public static long countCurr(long curr, long next, long n) {
        long countNum = 0;

        while (curr <= n) {
            countNum += (next - curr);

            curr *= 10;
            next *= 10;

            // doing this because humko agar next > n mil gaya to fir hum usko n+1 kar
            // denge, taaki next-curr agar kare to fir uss level mein atleast 1 node hoga hi
            // hoga, to wo n+1 se minus karke atleast 1 aa sake
            next = Math.min(next, n + 1);
        }

        return countNum;
    }

    public int findKthNumber(int n, int k) {
        long curr = 1;
        k--; // because curr is starting from 1, not 0

        while (k > 0) {
            long count = countCurr(curr, curr + 1, n);

            // iska matlab mera curr wala node ka tree ka kaam ni h
            if (count <= k) {
                curr++;
                k -= count;
            } else { // iska matlab mera curr wala node ka tree mein hi h, isiliye deep chalte h
                // because we are going deep, and only considering the root once
                curr *= 10;
                k--;
            }
        }
        return (int) curr;
    }
}