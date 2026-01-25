// Last updated: 1/25/2026, 10:53:25 PM
1class Solution {
2    public int arrangeCoins(int n) {
3        long left = 0, right = n;
4        while (left <= right) {
5            long mid = left + (right - left) / 2;
6            long coins = mid * (mid + 1) / 2;
7            if (coins == n) return (int) mid;
8            if (coins < n) left = mid + 1;
9            else right = mid - 1;
10        }
11        return (int) right;
12    }
13}
14