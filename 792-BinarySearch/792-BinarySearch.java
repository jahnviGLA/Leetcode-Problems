// Last updated: 1/19/2026, 1:15:23 PM


class Solution {
    public int search(int[] nums, int target) {
        int lft=0;
        int rht=nums.length-1;

        while(lft<=rht){
            int mid=lft+(rht-lft)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                lft=mid+1;
            }else{
                rht=mid-1;
            }
        }
        
        return -1;
    }
}