// Last updated: 5/25/2026, 11:26:51 PM
1import java.util.*;
2class Solution {
3    public boolean canReach(String s, int minJump, int maxJump) {
4        int n = s.length();
5        Queue<Integer> q = new LinkedList<>();
6        q.offer(0);
7        int farthest = 0;
8        while (!q.isEmpty()) {
9            int curr = q.poll();
10            int start = Math.max(curr + minJump, farthest + 1);
11            int end = Math.min(curr + maxJump, n - 1);
12            for (int next = start; next <= end; next++) {
13                if (s.charAt(next) == '0') {
14                    if (next == n - 1)
15                        return true;
16                    q.offer(next);
17                }
18            }
19            farthest = end;
20        }
21        return n == 1;
22    }
23}