// Last updated: 2/1/2026, 12:24:22 AM
1class Solution {
2    public int calculate(String s) {
3        int result = 0;
4        int num = 0;
5        int sign = 1;
6        Stack<Integer> stack = new Stack<>();
7        for (int i = 0; i < s.length(); i++) {
8            char ch = s.charAt(i);
9            if (Character.isDigit(ch)) {
10                num = num * 10 + (ch - '0');
11            }
12            else if (ch == '+') {
13                result += sign * num;
14                num = 0;
15                sign = 1;
16            }
17            else if (ch == '-') {
18                result += sign * num;
19                num = 0;
20                sign = -1;
21            }
22            else if (ch == '(') {
23                stack.push(result);
24                stack.push(sign);
25                result = 0;
26                sign = 1;
27            }
28            else if (ch == ')') {
29                result += sign * num;
30                num = 0;
31                result *= stack.pop(); 
32                result += stack.pop(); 
33            }
34        }
35        return result + sign * num;
36    }
37}
38