// Last updated: 2/14/2026, 8:44:06 PM
1class Solution {
2    public double champagneTower(int poured, int query_row, int query_glass) {
3        double[][] dp = new double[101][101]; 
4        dp[0][0] = poured;      
5        for (int i = 0; i < query_row; i++) {   
6            for (int j = 0; j <= i; j++) {                
7                if (dp[i][j] > 1) {
8                    double overflow = (dp[i][j] - 1) / 2.0;                    
9                    dp[i+1][j] += overflow;
10                    dp[i+1][j+1] += overflow;                   
11                    dp[i][j] = 1;  
12                }
13            }
14        }
15        return Math.min(1, dp[query_row][query_glass]);
16    }
17}
18