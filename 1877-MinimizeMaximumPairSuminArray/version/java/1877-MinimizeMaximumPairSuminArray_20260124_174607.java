// Last updated: 1/24/2026, 5:46:07 PM
1class Solution {
2    public int minPairSum(int[] nums) {
3        Arrays.sort(nums);      
4        int left = 0;
5        int right = nums.length - 1;
6        int maxPairSum = 0;   
7        while (left < right) {
8            maxPairSum = Math.max(maxPairSum, nums[left] + nums[right]);
9            left++;
10            right--;
11        }
12        return maxPairSum;
13    }
14}
15