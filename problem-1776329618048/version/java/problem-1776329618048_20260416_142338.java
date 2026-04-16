// Last updated: 4/16/2026, 2:23:38 PM
1import java.util.*;
2
3class Solution {
4    public List<Integer> solveQueries(int[] nums, int[] queries) {
5        int n = nums.length;
6        Map<Integer, List<Integer>> map = new HashMap<>();
7        for (int i = 0; i < n; i++) {
8            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
9        }
10        List<Integer> ans = new ArrayList<>();
11        for (int idx : queries) {
12            int val = nums[idx];
13            List<Integer> list = map.get(val);
14            if (list.size() == 1) {
15                ans.add(-1);
16                continue;
17            }
18            int pos = Collections.binarySearch(list, idx);
19            int prev = list.get((pos - 1 + list.size()) % list.size());
20            int next = list.get((pos + 1) % list.size());
21            int distPrev = Math.min(Math.abs(idx - prev), n - Math.abs(idx - prev));
22            int distNext = Math.min(Math.abs(idx - next), n - Math.abs(idx - next));
23            ans.add(Math.min(distPrev, distNext));
24        }
25        return ans;
26    }
27}