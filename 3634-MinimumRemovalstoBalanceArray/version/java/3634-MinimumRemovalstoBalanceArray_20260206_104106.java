// Last updated: 2/6/2026, 10:41:06 AM
1import java.util.Arrays;
2class Solution {
3    public int minRemoval(int[] nums, int k) {
4        Arrays.sort(nums);
5        int n=nums.length;
6        int l=0;
7        int maxLen=0;
8        for (int r=0;r<n;r++) {
9            while((long)nums[r]>(long)nums[l]*k) {
10                l++;
11            }
12            maxLen=Math.max(maxLen,r-l+1);
13        }
14        return n-maxLen;
15    }
16}
17