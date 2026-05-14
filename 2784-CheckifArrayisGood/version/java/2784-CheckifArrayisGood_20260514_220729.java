// Last updated: 5/14/2026, 10:07:29 PM
1class Solution {
2    public boolean isGood(int[] nums) {
3        int n = nums.length - 1;    
4        int[] freq = new int[n + 1];       
5        for (int num : nums) {
6            if (num < 1 || num > n) {
7                return false;
8            }
9            freq[num]++;
10        }
11        for (int i = 1; i < n; i++) {
12            if (freq[i] != 1) {
13                return false;
14            }
15        }
16        return freq[n] == 2;
17    }
18}