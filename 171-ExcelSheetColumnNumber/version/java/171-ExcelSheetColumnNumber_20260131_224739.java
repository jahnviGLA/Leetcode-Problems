// Last updated: 1/31/2026, 10:47:39 PM
1class Solution {
2    public int titleToNumber(String columnTitle) {
3        int result = 0;
4        for (int i = 0; i < columnTitle.length(); i++) {
5            char ch = columnTitle.charAt(i);
6            int value = ch - 'A' + 1;
7            result = result * 26 + value;
8        }
9        return result;
10    }
11}
12