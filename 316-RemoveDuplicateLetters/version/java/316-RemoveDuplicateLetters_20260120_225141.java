// Last updated: 1/20/2026, 10:51:41 PM
1class Solution {
2    public String removeDuplicateLetters(String s) {
3        int[] freq = new int[26];
4        boolean[] used = new boolean[26];
5
6        // Count frequency
7        for (char c : s.toCharArray()) {
8            freq[c - 'a']++;
9        }
10
11        StringBuilder stack = new StringBuilder();
12
13        for (char c : s.toCharArray()) {
14            int idx = c - 'a';
15            freq[idx]--;
16
17            if (used[idx]) continue;
18            while (stack.length() > 0) {
19                char last = stack.charAt(stack.length() - 1);
20                if (last > c && freq[last - 'a'] > 0) {
21                    used[last - 'a'] = false;
22                    stack.deleteCharAt(stack.length() - 1);
23                } else {
24                    break;
25                }
26            }
27
28            stack.append(c);
29            used[idx] = true;
30        }
31
32        return stack.toString();
33    }
34}
35