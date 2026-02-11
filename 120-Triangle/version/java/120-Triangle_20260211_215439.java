// Last updated: 2/11/2026, 9:54:39 PM
1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int n = triangle.size();
4        int[] dp = new int[n];
5        for (int i = 0; i < n; i++) {
6            dp[i] = triangle.get(n - 1).get(i);
7        }
8        for (int row = n - 2; row >= 0; row--) {
9            for (int col = 0; col <= row; col++) {
10                dp[col] = triangle.get(row).get(col) 
11                        + Math.min(dp[col], dp[col + 1]);
12            }
13        }
14        return dp[0];
15    }
16}
17