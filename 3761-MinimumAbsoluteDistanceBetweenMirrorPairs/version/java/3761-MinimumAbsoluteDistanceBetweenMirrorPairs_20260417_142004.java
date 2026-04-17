// Last updated: 4/17/2026, 2:20:04 PM
1import java.util.*;
2class Solution {
3    public int minMirrorPairDistance(int[] nums) {
4        Map<Integer, Integer> map = new HashMap<>();
5        int minDist = Integer.MAX_VALUE;
6        for (int j = 0; j < nums.length; j++) {
7            int num = nums[j];
8            if (map.containsKey(num)) {
9                int i = map.get(num);
10                minDist = Math.min(minDist, j - i);
11            }
12            int rev = reverse(num);
13            map.put(rev, j);
14        }
15        return minDist == Integer.MAX_VALUE ? -1 : minDist;
16    }
17    private int reverse(int x) {
18        int rev = 0;
19        while (x > 0) {
20            rev = rev * 10 + (x % 10);
21            x /= 10;
22        }
23        return rev;
24    }
25}