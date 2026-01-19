// Last updated: 1/19/2026, 1:16:47 PM
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return countWays(n, dp);
    }
    public int countWays(int n, int[] dp) {
        if (n <= 2) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = countWays(n-1, dp) + countWays(n-2, dp);
        return dp[n];
    }
}
