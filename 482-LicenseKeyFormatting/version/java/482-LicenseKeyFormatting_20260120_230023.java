// Last updated: 1/20/2026, 11:00:23 PM
1class Solution {
2    public String licenseKeyFormatting(String s, int k) {
3        StringBuilder sb = new StringBuilder();
4        int count = 0;
5        for (int i = s.length() - 1; i >= 0; i--) {
6            char c = s.charAt(i);
7            if (c == '-') continue;
8            sb.append(Character.toUpperCase(c));
9            count++;
10            if (count == k) {
11                sb.append('-');
12                count = 0;
13            }
14        }
15        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
16            sb.deleteCharAt(sb.length() - 1);
17        }
18        return sb.reverse().toString();
19    }
20}
21