// Last updated: 3/19/2026, 11:31:18 AM
1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;       
5        int[][] sum = new int[m][n];     
6        int[][] countX = new int[m][n];          
7        int result = 0;        
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                int val = 0;
11                if (grid[i][j] == 'X') val = 1;
12                else if (grid[i][j] == 'Y') val = -1;                
13                sum[i][j] = val;
14                countX[i][j] = (grid[i][j] == 'X') ? 1 : 0;
15                if (i > 0) {
16                    sum[i][j] += sum[i - 1][j];
17                    countX[i][j] += countX[i - 1][j];
18                }
19                if (j > 0) {
20                    sum[i][j] += sum[i][j - 1];
21                    countX[i][j] += countX[i][j - 1];
22                }
23                if (i > 0 && j > 0) {
24                    sum[i][j] -= sum[i - 1][j - 1];
25                    countX[i][j] -= countX[i - 1][j - 1];
26                }
27                if (sum[i][j] == 0 && countX[i][j] > 0) {
28                    result++;
29                }
30            }
31        }      
32        return result;
33    }
34}