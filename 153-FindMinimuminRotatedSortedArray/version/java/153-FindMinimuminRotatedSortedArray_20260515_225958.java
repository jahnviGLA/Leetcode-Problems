// Last updated: 5/15/2026, 10:59:58 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int low = 0;
4        int high = nums.length - 1;
5        while (low < high) {
6            int mid = low + (high - low) / 2;
7            if (nums[mid] > nums[high]) {
8                low = mid + 1;
9            }
10            else {
11                high = mid;
12            }
13        }
14        return nums[low];
15    }
16}