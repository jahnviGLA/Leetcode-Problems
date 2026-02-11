// Last updated: 2/11/2026, 10:43:49 PM
1import java.util.*;
2class Solution {
3    public boolean canCross(int[] stones) {
4        int n = stones.length;
5        if (stones[1] != 1) return false;
6        Map<Integer, Set<Integer>> map = new HashMap<>();
7        for (int stone : stones) {
8            map.put(stone, new HashSet<>());
9        }
10        map.get(0).add(0);
11        for (int stone : stones) {
12            for (int jump : map.get(stone)) {
13
14                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
15                    if (nextJump > 0) {
16                        int nextPosition = stone + nextJump;
17
18                        if (map.containsKey(nextPosition)) {
19                            map.get(nextPosition).add(nextJump);
20                        }
21                    }
22                }
23            }
24        }
25        return !map.get(stones[n - 1]).isEmpty();
26    }
27}
28