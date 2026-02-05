// Last updated: 2/5/2026, 2:39:22 PM
// this solution uses the concept of bit manipulation(XOR the elements)
1class Solution {
2    public int singleNumber(int[] nums) {
3        int val=0;
4        for(int i=0;i<nums.length;i++){
5            val=val^nums[i];
6        }
7        return val;
8    }
9}