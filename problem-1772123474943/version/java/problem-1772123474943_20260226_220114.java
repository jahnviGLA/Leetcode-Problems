// Last updated: 2/26/2026, 10:01:14 PM
1class Solution {
2    public int numSteps(String s) {
3        int steps = 0;
4        int carry = 0;
5        for (int i = s.length() - 1; i > 0; i--) {
6            int bit = s.charAt(i) - '0';           
7            if (bit + carry == 1) {
8                steps += 2;
9                carry = 1;   
10            } else {
11                steps += 1;
12            }
13        }
14        return steps + carry;
15    }
16}