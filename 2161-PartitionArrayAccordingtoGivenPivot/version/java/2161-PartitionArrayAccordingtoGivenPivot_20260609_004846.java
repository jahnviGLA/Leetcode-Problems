// Last updated: 6/9/2026, 12:48:46 AM
1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        int n = nums.length;
4        int[] ans = new int[n];
5        int index = 0;
6        for(int num : nums) {
7            if(num < pivot) {
8                ans[index] = num;
9                index++;
10            }
11        }
12        for(int num : nums) {
13            if(num == pivot) {
14                ans[index] = num;
15                index++;
16            }
17        }
18        for(int num : nums) {
19            if(num > pivot) {
20                ans[index] = num;
21                index++;
22            }
23        }
24        return ans;
25    }
26}