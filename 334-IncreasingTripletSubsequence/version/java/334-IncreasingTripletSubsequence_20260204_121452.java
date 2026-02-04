// Last updated: 2/4/2026, 12:14:52 PM
1class Solution {
2    public boolean increasingTriplet(int[] nums) {
3        int first = Integer.MAX_VALUE;
4        int second = Integer.MAX_VALUE;
5        for (int num : nums) {
6            if (num <= first) {
7                first = num;
8            } else if (num <= second) {
9                second = num;
10            } else {
11                return true;
12            }
13        }
14        return false;
15    }
16}
17