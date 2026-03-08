// Last updated: 3/8/2026, 10:14:26 PM
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        int n = nums.length;
4        StringBuilder ans = new StringBuilder();
5
6        for (int i = 0; i < n; i++) {
7            char c = nums[i].charAt(i);
8            
9            if (c == '0') {
10                ans.append('1');
11            } else {
12                ans.append('0');
13            }
14        }
15
16        return ans.toString();
17    }
18}