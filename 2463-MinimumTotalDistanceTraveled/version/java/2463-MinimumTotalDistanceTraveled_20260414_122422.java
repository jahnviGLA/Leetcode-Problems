// Last updated: 4/14/2026, 12:24:22 PM
1import java.util.*;
2class Solution {
3    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
4        Collections.sort(robot);
5        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
6        int n = robot.size();
7        int m = factory.length;
8        long[][] dp = new long[n + 1][m + 1];
9        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
10        dp[0][0] = 0;
11        for (int j = 1; j <= m; j++) {
12            int pos = factory[j - 1][0];
13            int limit = factory[j - 1][1];
14            for (int i = 0; i <= n; i++) {
15                dp[i][j] = dp[i][j - 1];
16                long cost = 0;
17                for (int k = 1; k <= Math.min(i, limit); k++) {
18                    cost += Math.abs(robot.get(i - k) - pos);
19
20                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
21                        dp[i][j] = Math.min(dp[i][j],
22                                dp[i - k][j - 1] + cost);
23                    }
24                }
25            }
26        }
27        return dp[n][m];
28    }
29}