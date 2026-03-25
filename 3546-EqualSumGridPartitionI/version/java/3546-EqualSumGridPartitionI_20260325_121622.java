// Last updated: 3/25/2026, 12:16:22 PM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        long total = 0;
6        for (int[] row : grid) {
7            for (int val : row) {
8                total += val;
9            }
10        }
11        if (total % 2 != 0) return false;
12        long half = total / 2;
13        long sum = 0;
14        for (int i = 0; i < m - 1; i++) { 
15            for (int j = 0; j < n; j++) {
16                sum += grid[i][j];
17            }
18            if (sum == half) return true;
19        }
20        sum = 0;
21        for (int j = 0; j < n - 1; j++) { 
22            for (int i = 0; i < m; i++) {
23                sum += grid[i][j];
24            }
25            if (sum == half) return true;
26        }
27        return false;
28    }
29}