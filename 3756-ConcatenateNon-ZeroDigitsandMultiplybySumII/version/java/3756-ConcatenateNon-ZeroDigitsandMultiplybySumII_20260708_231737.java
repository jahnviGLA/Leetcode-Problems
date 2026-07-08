// Last updated: 7/8/2026, 11:17:37 PM
1class Solution {
2
3    private static final int MOD = 1000000007;
4    private static final int MAX_N = 100001;
5    private static final long[] pow10 = new long[MAX_N];
6
7    // static runs only once for all test cases
8    static {
9        pow10[0] = 1;
10        for (int i = 1; i < MAX_N; ++i) {
11            pow10[i] = (pow10[i - 1] * 10) % MOD;
12        }
13    }
14
15    public int[] sumAndMultiply(String s, int[][] queries) {
16        int n = s.length();
17        int[] sum = new int[n + 1];
18        long[] x = new long[n + 1];
19        int[] cnt = new int[n + 1];
20        for (int i = 0; i < n; ++i) {
21            int d = s.charAt(i) - '0';
22            sum[i + 1] = sum[i] + d;
23            x[i + 1] = d > 0 ? (x[i] * 10 + d) % MOD : x[i];
24            cnt[i + 1] = cnt[i] + (d > 0 ? 1 : 0);
25        }
26        int m = queries.length;
27        int[] res = new int[m];
28        for (int i = 0; i < m; ++i) {
29            int l = queries[i][0];
30            int r = queries[i][1] + 1;
31            int length = cnt[r] - cnt[l];
32            long val_x = (x[r] - ((x[l] * pow10[length]) % MOD) + MOD) % MOD;
33            long val_sum = sum[r] - sum[l];
34            res[i] = (int) ((val_x * val_sum) % MOD);
35        }
36        return res;
37    }
38}