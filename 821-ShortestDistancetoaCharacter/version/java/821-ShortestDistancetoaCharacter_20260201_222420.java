// Last updated: 2/1/2026, 10:24:20 PM
1class Solution {
2    public int[] shortestToChar(String s, char c) {
3        int n = s.length();
4        int[] ans = new int[n];
5        int prev = -100000; 
6        for (int i = 0; i < n; i++) {
7            if (s.charAt(i) == c) {
8                prev = i;
9            }
10            ans[i] = i - prev;
11        }
12        prev = 100000; 
13        for (int i = n - 1; i >= 0; i--) {
14            if (s.charAt(i) == c) {
15                prev = i;
16            }
17            ans[i] = Math.min(ans[i], prev - i);
18        }
19        return ans;
20    }
21}
22