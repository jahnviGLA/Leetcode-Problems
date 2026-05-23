// Last updated: 5/23/2026, 11:39:12 PM
1class Solution {
2    public boolean check(int[] nums) {   
3        int count = 0;
4        int n = nums.length;
5        for(int i = 0; i < n; i++){
6            if(nums[i] > nums[(i + 1) % n]){
7                count++;
8            }
9            if(count > 1){
10                return false;
11            }
12        }
13        return true;
14    }
15}