// Last updated: 6/2/2026, 2:20:07 AM
1import java.util.*;
2
3class Solution {
4    public int minimumCost(int[] cost) {
5        Arrays.sort(cost);
6        int ans = 0;
7        int count = 0;
8        for (int i = cost.length - 1; i >= 0; i--) {
9            count++;
10            if (count == 3) {
11                count = 0;
12                continue;
13            }
14            ans += cost[i];
15        }
16        return ans;
17    }
18}