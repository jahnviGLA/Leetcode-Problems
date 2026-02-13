// Last updated: 2/13/2026, 3:00:26 PM
1import java.util.*;
2class Solution {
3    public static int has1(String s, int n) {
4        int cnt = 1, len = 1;
5        for (int i = 1; i < n; i++) {
6            if (s.charAt(i) == s.charAt(i - 1)) {
7                len++;
8            } else {
9                cnt = Math.max(cnt, len);
10                len = 1;
11            }
12        }
13        return Math.max(cnt, len);
14    }
15    static final long bias = 1L << 18;
16    static final int shift = 32;
17    static long pack(int x, int y) {
18        return ((long) (x + bias) << shift) | (long) (y + bias);
19    }
20    public int longestBalanced(String s) {
21        int n = s.length();
22        int ans = has1(s, n);
23        Map<Long, Integer> ab = new HashMap<>(n);
24        Map<Long, Integer> bc = new HashMap<>(n);
25        Map<Long, Integer> ca = new HashMap<>(n);
26        Map<Long, Integer> abc = new HashMap<>(n);
27        abc.put(pack(0, 0), -1);
28        ab.put(pack(0, 0), -1); 
29        bc.put(pack(0, 0), -1); 
30        ca.put(pack(0, 0), -1); 
31        int[] cnt = new int[3]; 
32        for (int i = 0; i < n; i++) {
33            cnt[s.charAt(i) - 'a']++;
34            int A = cnt[0], B = cnt[1], C = cnt[2];
35            long key = pack(B - A, C - A);
36            if (abc.containsKey(key)) {
37                ans = Math.max(ans, i - abc.get(key));
38            } else {
39                abc.put(key, i);
40            }
41            key = pack(A - B, C);
42            if (ab.containsKey(key)) {
43                ans = Math.max(ans, i - ab.get(key));
44            } else {
45                ab.put(key, i);
46            }
47            key = pack(B - C, A);
48            if (bc.containsKey(key)) {
49                ans = Math.max(ans, i - bc.get(key));
50            } else {
51                bc.put(key, i);
52            }
53            key = pack(C - A, B);
54            if (ca.containsKey(key)) {
55                ans = Math.max(ans, i - ca.get(key));
56            } else {
57                ca.put(key, i);
58            }
59        }
60        return ans;
61    }
62}