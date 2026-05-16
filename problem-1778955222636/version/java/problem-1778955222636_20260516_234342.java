// Last updated: 5/16/2026, 11:43:42 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int low = 0;
4        int high = nums.length - 1;
5        while (low < high) {
6            int mid = low + (high - low) / 2;
7            if (nums[mid] > nums[high]) {
8                low = mid + 1;
9            }
10            else if (nums[mid] < nums[high]) {
11                high = mid;
12            }
13            else {
14                high--;
15            }
16        }
17        return nums[low];
18    }
19}