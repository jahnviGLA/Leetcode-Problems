// Last updated: 3/28/2026, 11:17:35 PM
1class Solution {
2    public String findTheString(int[][] lcp) {
3        int n = lcp.length;
4        for (int i = 0; i < n; i++) {
5            if (lcp[i][i] != n - i) return "";
6            for (int j = 0; j < n; j++) {
7                if (lcp[i][j] != lcp[j][i]) return "";
8            }
9        }
10        int[] parent = new int[n];
11        for (int i = 0; i < n; i++) parent[i] = i;
12        for (int i = 0; i < n; i++) {
13            for (int j = i + 1; j < n; j++) {
14                if (lcp[i][j] > 0) {
15                    union(parent, i, j);
16                }
17            }
18        }
19        char[] word = new char[n];
20        char ch = 'a';
21        int[] groupChar = new int[n];
22        for (int i = 0; i < n; i++) groupChar[i] = -1;
23        for (int i = 0; i < n; i++) {
24            int root = find(parent, i);
25            if (groupChar[root] == -1) {
26                if (ch > 'z') return "";
27                groupChar[root] = ch++;
28            }
29            word[i] = (char) groupChar[root];
30        }
31        int[][] dp = new int[n][n];
32        for (int i = n - 1; i >= 0; i--) {
33            for (int j = n - 1; j >= 0; j--) {
34                if (word[i] == word[j]) {
35                    dp[i][j] = 1;
36                    if (i + 1 < n && j + 1 < n) {
37                        dp[i][j] += dp[i + 1][j + 1];
38                    }
39                }
40            }
41        }
42        for (int i = 0; i < n; i++) {
43            for (int j = 0; j < n; j++) {
44                if (dp[i][j] != lcp[i][j]) return "";
45            }
46        }
47        return new String(word);
48    }
49    private int find(int[] parent, int x) {
50        if (parent[x] != x) {
51            parent[x] = find(parent, parent[x]);
52        }
53        return parent[x];
54    }
55    private void union(int[] parent, int a, int b) {
56        int pa = find(parent, a);
57        int pb = find(parent, b);
58        if (pa != pb) parent[pa] = pb;
59    }
60}