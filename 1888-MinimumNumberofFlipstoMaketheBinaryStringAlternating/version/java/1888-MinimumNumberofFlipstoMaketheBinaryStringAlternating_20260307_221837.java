// Last updated: 3/7/2026, 10:18:37 PM
1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String str = s + s;
5
6        int diff1 = 0, diff2 = 0;
7        int res = Integer.MAX_VALUE;
8
9        for (int i = 0; i < str.length(); i++) {
10            char expected1 = (i % 2 == 0) ? '0' : '1'; // pattern 0101
11            char expected2 = (i % 2 == 0) ? '1' : '0'; // pattern 1010
12
13            if (str.charAt(i) != expected1) diff1++;
14            if (str.charAt(i) != expected2) diff2++;
15
16            if (i >= n) {
17                char prev = str.charAt(i - n);
18                char prevExpected1 = ((i - n) % 2 == 0) ? '0' : '1';
19                char prevExpected2 = ((i - n) % 2 == 0) ? '1' : '0';
20
21                if (prev != prevExpected1) diff1--;
22                if (prev != prevExpected2) diff2--;
23            }
24
25            if (i >= n - 1) {
26                res = Math.min(res, Math.min(diff1, diff2));
27            }
28        }
29
30        return res;
31    }
32}