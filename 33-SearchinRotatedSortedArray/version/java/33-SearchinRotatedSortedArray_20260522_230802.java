// Last updated: 5/22/2026, 11:08:02 PM
1class Solution {
2    public int search(int[] nums, int target) {      
3        int low = 0;
4        int high = nums.length - 1;
5        while(low <= high){
6            int mid = low + (high - low) / 2;
7            if(nums[mid] == target){
8                return mid;
9            }
10            if(nums[low] <= nums[mid]){
11                if(target >= nums[low] && target < nums[mid]){
12                    high = mid - 1;
13                }
14                else{
15                    low = mid + 1;
16                }
17            }
18            else{
19                if(target > nums[mid] && target <= nums[high]){
20                    low = mid + 1;
21                }
22                else{
23                    high = mid - 1;
24                }
25            }
26        }
27        return -1;
28    }
29}