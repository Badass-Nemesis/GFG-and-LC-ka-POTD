// Qes -> https://www.geeksforgeeks.org/problems/decode-the-string2444/1

import java.util.*;

class Solution {
    private static String repeatString(String str, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    static String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    temp.insert(0, stack.pop());
                }

                if (!stack.isEmpty() && stack.peek().equals("[")) {
                    stack.pop();
                }

                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty()) {
                    String top = stack.peek();
                    if (top.length() == 1 && Character.isDigit(top.charAt(0))) {
                        numStr.insert(0, stack.pop());
                    } else {
                        break;
                    }
                }

                int num = Integer.parseInt(numStr.toString());

                String repeatedString = repeatString(temp.toString(), num);

                stack.push(repeatedString);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}