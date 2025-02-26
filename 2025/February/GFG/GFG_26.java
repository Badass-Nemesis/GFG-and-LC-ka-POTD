// Qes -> https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1

import java.util.*;

class Solution {
    public static int[] nextSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }

        return ans;
    }

    public static int[] prevSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }

        return ans;
    }

    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int[] nextSmallArr = nextSmaller(arr);
        int[] prevSmallArr = prevSmaller(arr);

        int[] temp = new int[arr.length];
        Arrays.fill(temp, Integer.MIN_VALUE);

        for (int i = 0; i < arr.length; i++) {
            int windowSize = Math.abs(nextSmallArr[i] - prevSmallArr[i]) - 1; // window size for i-th element
            temp[windowSize - 1] = Math.max(arr[i], temp[windowSize - 1]);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int tempNum = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            tempNum = Math.max(tempNum, temp[i]);
            ans.add(tempNum);
        }
        Collections.reverse(ans);

        return ans;
    }
}