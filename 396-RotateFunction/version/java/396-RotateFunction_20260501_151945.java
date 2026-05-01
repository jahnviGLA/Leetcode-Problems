// Last updated: 5/1/2026, 3:19:45 PM
1class Solution {
2    public int maxRotateFunction(int[] nums) {
3        int n = nums.length;    
4        int sum = 0;
5        int f = 0;
6        for (int i = 0; i < n; i++) {
7            sum += nums[i];
8            f += i * nums[i];
9        }   
10        int max = f;
11        for (int k = 1; k < n; k++) {
12            f = f + sum - n * nums[n - k];
13            max = Math.max(max, f);
14        }   
15        return max;
16    }
17}