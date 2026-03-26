// Last updated: 3/26/2026, 3:49:45 PM
1import java.util.*;
2
3class Solution {
4    public boolean canPartitionGrid(int[][] grid) {
5        int m = grid.length, n = grid[0].length;
6        long total = 0;
7        for (int[] row : grid)
8            for (int v : row) total += v;
9
10        int[] rowSums = new int[m];
11        int[] colSums = new int[n];
12        for (int i = 0; i < m; i++)
13            for (int j = 0; j < n; j++) {
14                rowSums[i] += grid[i][j];
15                colSums[j] += grid[i][j];
16            }
17
18        // ── Horizontal cuts ───────────────────────────────────────────────
19        Map<Integer, Integer> suf = buildFreqMap(grid);
20        Set<Integer> pre = new HashSet<>();
21        long preSum = 0;
22
23        for (int i = 0; i < m - 1; i++) {
24            preSum += rowSums[i];
25            for (int v : grid[i]) {
26                pre.add(v);
27                removeFromMap(suf, v);
28            }
29            long sufSum = total - preSum;
30            Set<Integer> topC = corners(grid, 0, i, 0, n - 1);
31            Set<Integer> botC = corners(grid, i + 1, m - 1, 0, n - 1);
32            if (check(preSum, sufSum, i + 1, n, topC, m - i - 1, n, botC, pre, suf))
33                return true;
34        }
35
36        // ── Vertical cuts ─────────────────────────────────────────────────
37        suf = buildFreqMap(grid);
38        pre = new HashSet<>();
39        preSum = 0;
40
41        for (int j = 0; j < n - 1; j++) {
42            preSum += colSums[j];
43            for (int i = 0; i < m; i++) {
44                pre.add(grid[i][j]);
45                removeFromMap(suf, grid[i][j]);
46            }
47            long sufSum = total - preSum;
48            Set<Integer> lftC = corners(grid, 0, m - 1, 0, j);
49            Set<Integer> rgtC = corners(grid, 0, m - 1, j + 1, n - 1);
50            if (check(preSum, sufSum, m, j + 1, lftC, m, n - j - 1, rgtC, pre, suf))
51                return true;
52        }
53
54        return false;
55    }
56
57    private Map<Integer, Integer> buildFreqMap(int[][] grid) {
58        Map<Integer, Integer> map = new HashMap<>();
59        for (int[] row : grid)
60            for (int v : row)
61                map.merge(v, 1, Integer::sum);
62        return map;
63    }
64
65    private void removeFromMap(Map<Integer, Integer> map, int v) {
66        map.merge(v, -1, Integer::sum);
67        if (map.get(v) == 0) map.remove(v);
68    }
69
70    private Set<Integer> corners(int[][] grid, int r1, int r2, int c1, int c2) {
71        Set<Integer> s = new HashSet<>();
72        s.add(grid[r1][c1]);
73        s.add(grid[r1][c2]);
74        s.add(grid[r2][c1]);
75        s.add(grid[r2][c2]);
76        return s;
77    }
78
79    private boolean check(long s1, long s2,
80                          int r1, int c1, Set<Integer> corners1,
81                          int r2, int c2, Set<Integer> corners2,
82                          Set<Integer> set1, Map<Integer, Integer> set2) {
83        if (s1 == s2) return true;
84
85        long diff1 = s1 - s2;
86        if (diff1 > 0 && diff1 <= Integer.MAX_VALUE) {
87            int d = (int) diff1;
88            if (r1 == 1 || c1 == 1) { if (corners1.contains(d)) return true; }
89            else                     { if (set1.contains(d))     return true; }
90        }
91
92        long diff2 = s2 - s1;
93        if (diff2 > 0 && diff2 <= Integer.MAX_VALUE) {
94            int d = (int) diff2;
95            if (r2 == 1 || c2 == 1) { if (corners2.contains(d)) return true; }
96            else                     { if (set2.containsKey(d))  return true; }
97        }
98
99        return false;
100    }
101}