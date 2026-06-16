// Last updated: 6/16/2026, 8:05:00 PM
1class Solution {
2    public String processStr(String s) {
3        StringBuilder result = new StringBuilder();
4        for (char ch : s.toCharArray()) {
5            if (ch >= 'a' && ch <= 'z') {
6                result.append(ch);
7            } 
8            else if (ch == '*') {
9                if (result.length() > 0) {
10                    result.deleteCharAt(result.length() - 1);
11                }
12            } 
13            else if (ch == '#') {
14                result.append(result.toString());
15            } 
16            else if (ch == '%') {
17                result.reverse();
18            }
19        }
20        return result.toString();
21    }
22}