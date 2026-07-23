// Last updated: 7/23/2026, 7:13:20 PM
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4
5        if (n == 1) return 1;
6        if (n == 2) return 2;
7
8        return 1 << (32 - Integer.numberOfLeadingZeros(n));
9    }
10}