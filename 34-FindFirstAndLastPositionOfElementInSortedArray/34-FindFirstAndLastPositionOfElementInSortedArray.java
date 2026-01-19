// Last updated: 1/19/2026, 1:17:32 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0, r= nums.length-1;
        int ans[]={-1,-1};
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>target){
                r=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                if(mid==l || nums[mid]!=nums[mid-1]){
                    ans[0]=mid;
                    break;
                }
                else{
                    r=mid-1;
                }
            }
        }
        l=0;
        r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>target){
                r=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                if(mid==r || nums[mid]!=nums[mid+1]){
                    ans[1]=mid;
                    break;
                }
                else{
                    l=mid+1;
                }
            }
        }
        return ans;
    }
}