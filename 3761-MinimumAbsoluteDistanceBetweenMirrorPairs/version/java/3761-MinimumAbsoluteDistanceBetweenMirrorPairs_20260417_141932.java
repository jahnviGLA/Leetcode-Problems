// Last updated: 4/17/2026, 2:19:32 PM
1import java.util.*;
2
3class Solution {
4    public int minMirrorPairDistance(int[] nums) {
5        Map<Integer, Integer> map = new HashMap<>();
6        int minDist = Integer.MAX_VALUE;
7
8        for (int j = 0; j < nums.length; j++) {
9            int num = nums[j];
10
11            // If this number was expected (i.e., reverse of some previous)
12            if (map.containsKey(num)) {
13                int i = map.get(num);
14                minDist = Math.min(minDist, j - i);
15            }
16
17            // Store reverse of current number
18            int rev = reverse(num);
19            map.put(rev, j);
20        }
21
22        return minDist == Integer.MAX_VALUE ? -1 : minDist;
23    }
24
25    private int reverse(int x) {
26        int rev = 0;
27        while (x > 0) {
28            rev = rev * 10 + (x % 10);
29            x /= 10;
30        }
31        return rev;
32    }
33}