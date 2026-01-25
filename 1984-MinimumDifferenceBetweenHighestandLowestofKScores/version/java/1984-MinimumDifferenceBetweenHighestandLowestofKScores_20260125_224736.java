// Last updated: 1/25/2026, 10:47:36 PM
1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3        if (k == 1) return 0;
4
5        Arrays.sort(nums);
6        int minDiff = Integer.MAX_VALUE;
7
8        for (int i = 0; i + k - 1 < nums.length; i++) {
9            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
10        }
11
12        return minDiff;
13    }
14}
15