// Last updated: 6/6/2026, 9:54:41 PM
1class Solution {
2
3    public int[] leftRightDifference(int[] nums) {
4        int n = nums.length;
5        int[] ans = new int[n];
6
7        int leftSum = 0;
8        for (int i = 0; i < n; ++i) {
9            ans[i] = leftSum;
10            leftSum += nums[i];
11        }
12
13        int rightSum = 0;
14        for (int i = n - 1; i >= 0; --i) {
15            ans[i] = Math.abs(ans[i] - rightSum);
16            rightSum += nums[i];
17        }
18
19        return ans;
20    }
21}