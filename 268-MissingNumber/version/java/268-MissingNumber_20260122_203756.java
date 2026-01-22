// Last updated: 1/22/2026, 8:37:56 PM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int n = nums.length;
4        int xor = 0;
5        for (int i = 0; i <= n; i++) {
6            xor ^= i;
7        }
8        for (int num : nums) {
9            xor ^= num;
10        }
11        return xor;
12    }
13}
14