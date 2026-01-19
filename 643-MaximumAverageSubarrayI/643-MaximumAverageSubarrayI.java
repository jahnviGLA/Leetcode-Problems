// Last updated: 1/19/2026, 1:15:32 PM
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        long maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += nums[i];       
            windowSum -= nums[i - k];   
            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum / k;
    }
}
