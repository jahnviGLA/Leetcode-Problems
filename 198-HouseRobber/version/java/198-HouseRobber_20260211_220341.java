// Last updated: 2/11/2026, 10:03:41 PM
1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        if (n == 1) return nums[0];
5        int[] dp = new int[n];
6        dp[0] = nums[0];
7        dp[1] = Math.max(nums[0], nums[1]);
8        for (int i = 2; i < n; i++) {
9            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
10        }
11        return dp[n - 1];
12    }
13}
14