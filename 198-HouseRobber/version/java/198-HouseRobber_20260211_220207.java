// Last updated: 2/11/2026, 10:02:07 PM
1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        if (n == 1) return nums[0];
5
6        int[] dp = new int[n];
7        dp[0] = nums[0];
8        dp[1] = Math.max(nums[0], nums[1]);
9
10        for (int i = 2; i < n; i++) {
11            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
12        }
13
14        return dp[n - 1];
15    }
16}
17