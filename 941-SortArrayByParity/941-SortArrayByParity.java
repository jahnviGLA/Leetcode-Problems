// Last updated: 1/19/2026, 1:15:16 PM
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            // If left is odd and right is even, swap
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            
            // Move left if it's already even
            if (nums[left] % 2 == 0) left++;
            
            // Move right if it's already odd
            if (nums[right] % 2 == 1) right--;
        }
        
        return nums;
    }
}
