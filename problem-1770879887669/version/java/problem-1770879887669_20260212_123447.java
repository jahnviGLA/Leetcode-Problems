// Last updated: 2/12/2026, 12:34:47 PM
1class Solution {
2    public boolean search(int[] nums, int target) {
3        int left=0,right=nums.length-1;
4        while (left<=right) {
5            int mid=left+(right-left)/2;
6            if (nums[mid]==target)
7                return true;
8            if (nums[left]==nums[mid] && nums[mid]==nums[right]) {
9                left++;
10                right--;
11            }
12            else if (nums[left]<=nums[mid]) {
13                if (nums[left]<=target && target<nums[mid])
14                    right=mid-1;
15                else
16                    left=mid+1;
17            }
18            else {
19                if (nums[mid]<target && target<=nums[right])
20                    left=mid+1;
21                else
22                    right=mid-1;
23            }
24        }
25        return false;
26    }
27}
28