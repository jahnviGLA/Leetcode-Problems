// Last updated: 7/7/2026, 12:44:35 PM
1class Solution {
2    public int search(int[] nums, int target) {
3        int low=0, high=nums.length-1;
4        while(low<=high){
5            int mid=(low+high)/2;
6            if(nums[mid]==target){
7                return mid;
8            }
9            else if(target<nums[mid]){
10                high=mid-1;
11            }
12            else if(target>nums[mid]){
13                low=mid+1;
14            }
15            
16        }
17        return -1;
18    }
19}