// Last updated: 5/10/2026, 11:31:27 PM
1import java.util.*;
2class Solution {
3    public int maximumJumps(int[] nums, int target) {
4        int n = nums.length;
5        int[] dp = new int[n];
6        Arrays.fill(dp, -1);
7        dp[0] = 0;
8        for (int i = 0; i < n; i++) {
9            if (dp[i] == -1) continue;
10            for (int j = i + 1; j < n; j++) {
11                long diff = (long) nums[j] - nums[i];
12                if (diff >= -target && diff <= target) {
13                    dp[j] = Math.max(dp[j], dp[i] + 1);
14                }
15            }
16        }
17        return dp[n - 1];
18    }
19}