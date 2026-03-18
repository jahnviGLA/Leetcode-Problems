// Last updated: 3/18/2026, 11:24:47 PM
1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;        
5        int count = 0;
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {                
8                if (i > 0) grid[i][j] += grid[i - 1][j];
9                if (j > 0) grid[i][j] += grid[i][j - 1];
10                if (i > 0 && j > 0) grid[i][j] -= grid[i - 1][j - 1];
11                if (grid[i][j] <= k) {
12                    count++;
13                }
14            }
15        }       
16        return count;
17    }
18}