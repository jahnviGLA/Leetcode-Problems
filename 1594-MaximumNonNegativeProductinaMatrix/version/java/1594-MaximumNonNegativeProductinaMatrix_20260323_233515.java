// Last updated: 3/23/2026, 11:35:15 PM
1class Solution {
2    public int maxProductPath(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;        
5        long[][] max = new long[m][n];
6        long[][] min = new long[m][n];        
7        max[0][0] = min[0][0] = grid[0][0];
8        for (int i = 1; i < m; i++) {
9            max[i][0] = max[i - 1][0] * grid[i][0];
10            min[i][0] = max[i][0];
11        }
12        for (int j = 1; j < n; j++) {
13            max[0][j] = max[0][j - 1] * grid[0][j];
14            min[0][j] = max[0][j];
15        }        
16        for (int i = 1; i < m; i++) {
17            for (int j = 1; j < n; j++) {
18                long val = grid[i][j];                
19                long a = max[i - 1][j] * val;
20                long b = min[i - 1][j] * val;
21                long c = max[i][j - 1] * val;
22                long d = min[i][j - 1] * val;                
23                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
24                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
25            }
26        }        
27        long result = max[m - 1][n - 1];
28        if (result < 0) return -1;        
29        int MOD = 1_000_000_007;
30        return (int)(result % MOD);
31    }
32}