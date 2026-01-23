// Last updated: 1/23/2026, 10:55:59 PM
1class Solution {
2    public int numberOfArithmeticSlices(int[] nums) {
3        int n = nums.length;
4        if (n < 3) return 0;
5        int total = 0;
6        int curr = 0;
7        for (int i = 2; i < n; i++) {
8            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
9                curr = curr + 1;
10                total += curr;
11            } else {
12                curr = 0;
13            }
14        }
15        return total;
16    }
17}
18