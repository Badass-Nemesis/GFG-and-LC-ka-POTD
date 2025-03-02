// Qes -> https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/ 

import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Set<Integer> ids = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            ids.add(nums1[i][0]);
        }
        for (int i = 0; i < nums2.length; i++) {
            ids.add(nums2[i][0]);
        }

        int[][] ans = new int[ids.size()][2];

        int ptr1 = 0;
        int ptr2 = 0;
        int ansPtr = 0;

        while (ansPtr < ans.length && ptr1 < nums1.length && ptr2 < nums2.length) {
            int[] temp1 = nums1[ptr1];
            int[] temp2 = nums2[ptr2];

            if (temp1[0] == temp2[0]) {
                // same ids
                ans[ansPtr][0] = temp1[0];
                ans[ansPtr][1] = temp1[1] + temp2[1];

                ansPtr++;
                ptr1++;
                ptr2++;
            } else if (temp1[0] < temp2[0]) {
                // nums1 id should be put first then
                ans[ansPtr][0] = temp1[0];
                ans[ansPtr][1] = temp1[1];

                ansPtr++;
                ptr1++;
            } else if (temp2[0] < temp1[0]) {
                // nums2 id should be put first then
                ans[ansPtr][0] = temp2[0];
                ans[ansPtr][1] = temp2[1];

                ansPtr++;
                ptr2++;
            }
        }

        while (ansPtr < ans.length && ptr1 < nums1.length) {
            int[] temp1 = nums1[ptr1];

            ans[ansPtr][0] = temp1[0];
            ans[ansPtr][1] = temp1[1];

            ansPtr++;
            ptr1++;
        }

        while (ansPtr < ans.length && ptr2 < nums2.length) {
            int[] temp2 = nums2[ptr2];

            ans[ansPtr][0] = temp2[0];
            ans[ansPtr][1] = temp2[1];

            ansPtr++;
            ptr2++;
        }

        return ans;
    }
}