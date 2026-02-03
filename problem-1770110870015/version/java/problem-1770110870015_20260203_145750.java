// Last updated: 2/3/2026, 2:57:50 PM
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int n = nums.length;
4        if (n < 4) return false;
5        int c = 0;                 
6        boolean hasInc = false;    
7        boolean hasDec = false;    
8        for (int i = 1; i < n; i++) {
9            if (nums[i] == nums[i - 1]) return false;
10            if (c == 0) {
11                if (nums[i] > nums[i - 1]) {
12                    hasInc = true;
13                } else {
14                    if (!hasInc) return false;
15                    c = 1;
16                    hasDec = true;
17                }
18            }
19            else if (c == 1) {
20                if (nums[i] < nums[i - 1]) {
21                    hasDec = true;
22                } else {
23                    c = 2;
24                }
25            }
26            else {
27                if (nums[i] < nums[i - 1]) return false;
28            }
29        }
30        return c == 2 && hasInc && hasDec;
31    }
32}
33