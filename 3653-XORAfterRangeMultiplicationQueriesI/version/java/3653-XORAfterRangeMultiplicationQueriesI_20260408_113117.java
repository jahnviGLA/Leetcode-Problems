// Last updated: 4/8/2026, 11:31:17 AM
1class Solution {
2    public int xorAfterQueries(int[] nums, int[][] queries) {
3        int MOD = 1_000_000_007;
4
5        for (int[] q : queries) {
6            int li = q[0];
7            int ri = q[1];
8            int ki = q[2];
9            int vi = q[3];
10
11            for (int idx = li; idx <= ri; idx += ki) {
12                nums[idx] = (int)((1L * nums[idx] * vi) % MOD);
13            }
14        }
15
16        int xor = 0;
17        for (int num : nums) {
18            xor ^= num;
19        }
20
21        return xor;
22    }
23}