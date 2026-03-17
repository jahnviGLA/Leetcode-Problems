// Last updated: 3/17/2026, 11:45:40 PM
1import java.util.*;
2
3class Solution {
4    public int calculate(String s) {
5        Stack<Integer> stack = new Stack<>();
6        int num = 0;
7        char sign = '+'; 
8        for (int i = 0; i < s.length(); i++) {
9            char c = s.charAt(i);
10            if (Character.isDigit(c)) {
11                num = num * 10 + (c - '0');
12            }
13            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
14                if (sign == '+') {
15                    stack.push(num);
16                } else if (sign == '-') {
17                    stack.push(-num);
18                } else if (sign == '*') {
19                    stack.push(stack.pop() * num);
20                } else if (sign == '/') {
21                    stack.push(stack.pop() / num);
22                }
23                sign = c;
24                num = 0;
25            }
26        }
27        int result = 0;
28        for (int val : stack) {
29            result += val;
30        }
31        return result;
32    }
33}