// Last updated: 2/9/2026, 10:43:38 PM
1class Solution {
2    public int findContentChildren(int[] g, int[] s) {
3        Arrays.sort(g);
4        Arrays.sort(s);
5        int i = 0, j = 0;
6        int count = 0;
7        while (i < g.length && j < s.length) {
8            if (s[j] >= g[i]) {
9                count++;
10                i++;
11                j++;
12            } else {
13                j++;
14            }
15        }
16        return count;
17    }
18}
19