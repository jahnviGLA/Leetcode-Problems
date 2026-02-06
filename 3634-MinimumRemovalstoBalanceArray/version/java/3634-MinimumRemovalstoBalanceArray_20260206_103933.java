// Last updated: 2/6/2026, 10:39:33 AM
1import java.util.Arrays;
2
3class Solution {
4    public int minRemoval(int[] nums, int k) {
5        Arrays.sort(nums);
6        int n = nums.length;
7        int l = 0;
8        int maxLen = 0;
9        for (int r = 0; r < n; r++) {
10            while ((long) nums[r] > (long) nums[l] * k) {
11                l++;
12            }
13            maxLen = Math.max(maxLen, r - l + 1);
14        }
15        return n - maxLen;
16    }
17}
18