// Last updated: 1/20/2026, 10:45:59 PM
1import java.util.List;
2
3class Solution {
4    public int[] minBitwiseArray(List<Integer> nums) {
5        int n = nums.size();
6        int[] ans = new int[n];
7        for (int i = 0; i < n; i++) {
8            int p = nums.get(i);
9            ans[i] = -1;
10            for (int a = 0; a < p; a++) {
11                if ((a | (a + 1)) == p) {
12                    ans[i] = a;
13                    break;
14                }
15            }
16        }
17        return ans;
18    }
19}
20