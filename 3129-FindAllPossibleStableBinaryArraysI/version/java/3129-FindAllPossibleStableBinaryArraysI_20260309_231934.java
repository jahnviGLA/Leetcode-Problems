// Last updated: 3/9/2026, 11:19:34 PM
1class Solution {
2
3    static final int MOD = 1_000_000_007;
4
5    public int numberOfStableArrays(int zero, int one, int limit) {
6
7        long[][][] dp = new long[zero + 1][one + 1][2];
8
9        for (int i = 1; i <= Math.min(limit, zero); i++)
10            dp[i][0][0] = 1;
11
12        for (int j = 1; j <= Math.min(limit, one); j++)
13            dp[0][j][1] = 1;
14
15        for (int i = 0; i <= zero; i++) {
16            for (int j = 0; j <= one; j++) {
17
18                for (int k = 1; k <= limit && i - k >= 0; k++) {
19                    dp[i][j][0] = (dp[i][j][0] + dp[i-k][j][1]) % MOD;
20                }
21
22                for (int k = 1; k <= limit && j - k >= 0; k++) {
23                    dp[i][j][1] = (dp[i][j][1] + dp[i][j-k][0]) % MOD;
24                }
25
26            }
27        }
28
29        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
30    }
31}