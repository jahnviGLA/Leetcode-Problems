// Last updated: 4/15/2026, 12:29:01 PM
1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex) {
3        int n = words.length;
4        int ans = Integer.MAX_VALUE;
5        for (int i = 0; i < n; i++) {
6            if (words[i].equals(target)) {
7                int right = (i - startIndex + n) % n;
8                int left = (startIndex - i + n) % n;
9                int dist = Math.min(right, left);
10                ans = Math.min(ans, dist);
11            }
12        }
13        return ans == Integer.MAX_VALUE ? -1 : ans;
14    }
15}