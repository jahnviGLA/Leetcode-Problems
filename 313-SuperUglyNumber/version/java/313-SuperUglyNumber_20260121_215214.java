// Last updated: 1/21/2026, 9:52:14 PM
1class Solution {
2    public int nthSuperUglyNumber(int n, int[] primes) {
3        int k = primes.length;
4        int[] dp = new int[n];
5        int[] idx = new int[k];
6        dp[0] = 1;
7        for (int i = 1; i < n; i++) {
8            long min = Long.MAX_VALUE;
9            for (int j = 0; j < k; j++) {
10                min = Math.min(min, (long) primes[j] * dp[idx[j]]);
11            }
12            dp[i] = (int) min;
13            for (int j = 0; j < k; j++) {
14                if ((long) primes[j] * dp[idx[j]] == min) {
15                    idx[j]++;
16                }
17            }
18        }
19        return dp[n - 1];
20    }
21}
22