// Last updated: 8/27/2026, 12:02:18 AM
1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        int n = s.length();
4        int minLen = Integer.MAX_VALUE;
5        String ans = "";
6        for (int i = 0; i < n; i++) {
7            int ones = 0;
8            for (int j = i; j < n; j++) {
9                if (s.charAt(j) == '1') {
10                    ones++;
11                }
12                if (ones == k) {
13                    int len = j - i + 1;
14                    String curr = s.substring(i, j + 1);
15                    if (len < minLen) {
16                        minLen = len;
17                        ans = curr;
18                    }
19                    else if (len == minLen && curr.compareTo(ans) < 0) {
20                        ans = curr;
21                    }
22                    break;
23                }
24            }
25        }
26        return ans;
27    }
28}