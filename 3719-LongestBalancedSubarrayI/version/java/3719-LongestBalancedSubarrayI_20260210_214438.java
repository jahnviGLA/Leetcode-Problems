// Last updated: 2/10/2026, 9:44:38 PM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        int n = nums.length;
4        int maxLen = 0;
5        for (int i = 0; i < n; i++) {
6            HashSet<Integer> evenSet = new HashSet<>();
7            HashSet<Integer> oddSet = new HashSet<>();
8            for (int j = i; j < n; j++) {
9                if (nums[j] % 2 == 0) {
10                    evenSet.add(nums[j]);
11                } else {
12                    oddSet.add(nums[j]);
13                }
14                if (evenSet.size() == oddSet.size()) {
15                    maxLen = Math.max(maxLen, j - i + 1);
16                }
17            }
18        }
19        return maxLen;
20    }
21}
22