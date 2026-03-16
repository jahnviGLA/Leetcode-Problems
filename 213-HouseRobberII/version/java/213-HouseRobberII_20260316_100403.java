// Last updated: 3/16/2026, 10:04:03 AM
1class Solution {
2
3    public int rob(int[] nums) {
4
5        int n = nums.length;
6
7        if (n == 1) return nums[0];
8
9        return Math.max(robLinear(nums, 0, n - 2),
10                        robLinear(nums, 1, n - 1));
11    }
12
13    private int robLinear(int[] nums, int start, int end) {
14
15        int prev1 = 0;
16        int prev2 = 0;
17
18        for (int i = start; i <= end; i++) {
19
20            int pick = nums[i] + prev2;
21            int skip = prev1;
22
23            int curr = Math.max(pick, skip);
24
25            prev2 = prev1;
26            prev1 = curr;
27        }
28
29        return prev1;
30    }
31}