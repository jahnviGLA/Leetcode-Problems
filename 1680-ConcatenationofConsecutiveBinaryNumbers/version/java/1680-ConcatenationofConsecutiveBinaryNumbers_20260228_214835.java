// Last updated: 2/28/2026, 9:48:35 PM
1class Solution {
2    public int concatenatedBinary(int n) {
3        long result = 0;
4        int bitLength = 0;
5        int MOD = 1_000_000_007;        
6        for (int i = 1; i <= n; i++) {
7            if ((i & (i - 1)) == 0) {
8                bitLength++;
9            }            
10            result = ((result << bitLength) + i) % MOD;
11        }        
12        return (int) result;
13    }
14}