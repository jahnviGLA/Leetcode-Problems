// Last updated: 1/27/2026, 11:27:59 PM
// this solution uses binary search to find the target element in an array
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