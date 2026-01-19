// Last updated: 1/19/2026, 11:43:32 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int max = nums[0];
4        int min = nums[0];
5        int ans = nums[0];
6        for (int i = 1; i < nums.length; i++) {
7            if (nums[i] < 0) {
8                int temp = max;
9                max = min;
10                min = temp;
11            }
12            max = Math.max(nums[i], max * nums[i]);
13            min = Math.min(nums[i], min * nums[i]);
14            ans = Math.max(ans, max);
15        }
16        return ans;
17    }
18}
19