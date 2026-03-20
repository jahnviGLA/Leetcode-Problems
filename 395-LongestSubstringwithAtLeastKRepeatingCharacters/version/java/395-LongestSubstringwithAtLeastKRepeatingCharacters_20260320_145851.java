// Last updated: 3/20/2026, 2:58:51 PM
1class Solution {
2    public int longestSubstring(String s, int k) {
3        return helper(s, 0, s.length(), k);
4    }
5    private int helper(String s, int start, int end, int k) {
6        if (end - start < k) return 0;
7        int[] freq = new int[26];
8        for (int i = start; i < end; i++) {
9            freq[s.charAt(i) - 'a']++;
10        }
11        for (int mid = start; mid < end; mid++) {
12            if (freq[s.charAt(mid) - 'a'] < k) {
13                int next = mid + 1;
14                while (next < end && freq[s.charAt(next) - 'a'] < k) {
15                    next++;
16                }
17                return Math.max(
18                        helper(s, start, mid, k),
19                        helper(s, next, end, k)
20                );
21            }
22        }
23        return end - start;
24    }
25}