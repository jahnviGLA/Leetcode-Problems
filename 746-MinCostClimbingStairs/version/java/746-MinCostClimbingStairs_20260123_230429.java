// Last updated: 1/23/2026, 11:04:29 PM
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n = cost.length;
4        int prev2 = 0; 
5        int prev1 = 0; 
6        for (int i = 2; i <= n; i++) {
7            int curr = Math.min(
8                prev1 + cost[i - 1],
9                prev2 + cost[i - 2]
10            );
11            prev2 = prev1;
12            prev1 = curr;
13        }
14        return prev1;
15    }
16}
17