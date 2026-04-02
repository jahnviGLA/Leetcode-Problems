// Last updated: 4/2/2026, 10:42:10 PM
1class Solution {
2    public int maximumAmount(int[][] coins) {
3        int m = coins.length, n = coins[0].length;
4
5        int[][][] dp = new int[m][n][3];
6
7        // Initialize with very small values
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                for (int k = 0; k < 3; k++) {
11                    dp[i][j][k] = Integer.MIN_VALUE;
12                }
13            }
14        }
15
16        // Base case (0,0)
17        for (int k = 0; k < 3; k++) {
18            if (coins[0][0] >= 0) {
19                dp[0][0][k] = coins[0][0];
20            } else {
21                if (k > 0)
22                    dp[0][0][k] = 0; // neutralize
23                else
24                    dp[0][0][k] = coins[0][0];
25            }
26        }
27
28        for (int i = 0; i < m; i++) {
29            for (int j = 0; j < n; j++) {
30                for (int k = 0; k < 3; k++) {
31
32                    if (i == 0 && j == 0) continue;
33
34                    int best = Integer.MIN_VALUE;
35
36                    // from top
37                    if (i > 0 && dp[i-1][j][k] != Integer.MIN_VALUE) {
38                        best = Math.max(best, dp[i-1][j][k]);
39                    }
40
41                    // from left
42                    if (j > 0 && dp[i][j-1][k] != Integer.MIN_VALUE) {
43                        best = Math.max(best, dp[i][j-1][k]);
44                    }
45
46                    if (best == Integer.MIN_VALUE) continue;
47
48                    // Case 1: take value
49                    dp[i][j][k] = Math.max(dp[i][j][k], best + coins[i][j]);
50
51                    // Case 2: neutralize if negative
52                    if (coins[i][j] < 0 && k > 0) {
53                        int bestPrev = Integer.MIN_VALUE;
54
55                        if (i > 0 && dp[i-1][j][k-1] != Integer.MIN_VALUE)
56                            bestPrev = Math.max(bestPrev, dp[i-1][j][k-1]);
57
58                        if (j > 0 && dp[i][j-1][k-1] != Integer.MIN_VALUE)
59                            bestPrev = Math.max(bestPrev, dp[i][j-1][k-1]);
60
61                        if (bestPrev != Integer.MIN_VALUE) {
62                            dp[i][j][k] = Math.max(dp[i][j][k], bestPrev);
63                        }
64                    }
65                }
66            }
67        }
68
69        int ans = Integer.MIN_VALUE;
70        for (int k = 0; k < 3; k++) {
71            ans = Math.max(ans, dp[m-1][n-1][k]);
72        }
73
74        return ans;
75    }
76}