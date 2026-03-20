// Last updated: 3/20/2026, 2:32:08 PM
1import java.util.*;
2class Solution {
3    public int[][] minAbsDiff(int[][] grid, int k) {
4        int m = grid.length;
5        int n = grid[0].length;
6        int[][] ans = new int[m - k + 1][n - k + 1];
7        for (int i = 0; i <= m - k; i++) {
8            for (int j = 0; j <= n - k; j++) {
9                List<Integer> list = new ArrayList<>();
10                for (int x = i; x < i + k; x++) {
11                    for (int y = j; y < j + k; y++) {
12                        list.add(grid[x][y]);
13                    }
14                }
15                Collections.sort(list);
16                int minDiff = Integer.MAX_VALUE;
17                for (int t = 1; t < list.size(); t++) {
18                    if (!list.get(t).equals(list.get(t - 1))) { 
19                        minDiff = Math.min(minDiff, list.get(t) - list.get(t - 1));
20                    }
21                }
22                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
23            }
24        }
25        return ans;
26    }
27}