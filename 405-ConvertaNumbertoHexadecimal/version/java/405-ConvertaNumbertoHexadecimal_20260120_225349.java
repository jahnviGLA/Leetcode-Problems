// Last updated: 1/20/2026, 10:53:49 PM
1class Solution {
2    public String toHex(int num) {
3        if (num == 0) return "0";
4
5        String hex = "0123456789abcdef";
6        StringBuilder sb = new StringBuilder();
7
8        while (num != 0) {
9            int digit = num & 15;        
10            sb.append(hex.charAt(digit));
11            num >>>= 4;                  
12        }
13
14        return sb.reverse().toString();
15    }
16}
17