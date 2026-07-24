// Last updated: 7/24/2026, 9:44:09 PM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        final int MAX = 2048;
4        boolean[][] dp = new boolean[4][MAX];
5        dp[0][0] = true;
6        for (int num : nums) {
7            for (int cnt = 2; cnt >= 0; cnt--) {
8                for (int x = 0; x < MAX; x++) {
9                    if (dp[cnt][x]) {
10                        dp[cnt + 1][x ^ num] = true;
11                    }
12                }
13            }
14        }
15        boolean[] seen = new boolean[MAX];
16        for (int x = 0; x < MAX; x++) {
17            if (dp[1][x]) seen[x] = true;
18        }
19        for (int x = 0; x < MAX; x++) {
20            if (dp[3][x]) seen[x] = true;
21        }
22        int ans = 0;
23        for (boolean b : seen) {
24            if (b) ans++;
25        }
26        return ans;
27    }
28}