// Last updated: 3/21/2026, 11:55:45 PM
1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        for (int i = 0; i < k / 2; i++) {
4            int row1 = x + i;
5            int row2 = x + k - 1 - i;
6            
7            for (int j = y; j < y + k; j++) {
8                int temp = grid[row1][j];
9                grid[row1][j] = grid[row2][j];
10                grid[row2][j] = temp;
11            }
12        }
13        
14        return grid;
15    }
16}