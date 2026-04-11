// Last updated: 4/11/2026, 10:34:28 PM
1import java.util.*;
2class Solution {
3    public int minimumDistance(int[] nums) {
4        Map<Integer, List<Integer>> map = new HashMap<>();
5        for (int i = 0; i < nums.length; i++) {
6            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
7        }
8        int minDist = Integer.MAX_VALUE;
9        for (List<Integer> list : map.values()) {
10            if (list.size() < 3) continue;
11            for (int i = 0; i <= list.size() - 3; i++) {
12                int dist = 2 * (list.get(i + 2) - list.get(i));
13                minDist = Math.min(minDist, dist);
14            }
15        }
16        return minDist == Integer.MAX_VALUE ? -1 : minDist;
17    }
18}