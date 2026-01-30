// Last updated: 1/30/2026, 10:08:23 PM
1import java.util.*;
2class Solution {
3    static class TrieNode {
4        TrieNode[] ch = new TrieNode[26];
5        int id = -1;
6    }
7    public long minimumCost(String source, String target,
8                            String[] original, String[] changed, int[] cost) {
9        int m = original.length;
10        TrieNode root = new TrieNode();
11        Map<String, Integer> idMap = new HashMap<>();
12        int idCnt = 0;
13        final long INF = (long)4e18;
14        long[][] dist = new long[2 * m + 5][2 * m + 5];
15        for (int i = 0; i < dist.length; i++) {
16            Arrays.fill(dist[i], INF);
17            dist[i][i] = 0;
18        }
19        for (int i = 0; i < m; i++) {
20            int a = getId(root, original[i], idMap, idCnt);
21            if (a == idCnt) idCnt++;
22            int b = getId(root, changed[i], idMap, idCnt);
23            if (b == idCnt) idCnt++;
24            dist[a][b] = Math.min(dist[a][b], (long)cost[i]);
25        }
26        int nIds = idCnt;
27        for (int k = 0; k < nIds; k++) {
28            for (int i = 0; i < nIds; i++) {
29                if (dist[i][k] == INF) continue;
30                for (int j = 0; j < nIds; j++) {
31                    if (dist[k][j] == INF) continue;
32                    long cand = dist[i][k] + dist[k][j];
33                    if (cand < dist[i][j]) dist[i][j] = cand;
34                }
35            }
36        }
37        int n = source.length();
38        Long[] dp = new Long[n + 1];
39        long ans = solve(0, source, target, root, dist, dp, INF);
40        if (ans >= INF) return -1;
41        return ans;
42    }
43    private int getId(TrieNode root, String s,
44                      Map<String, Integer> map, int nextId) {
45        Integer cached = map.get(s);
46        if (cached != null) return cached;
47        TrieNode cur = root;
48        for (char c : s.toCharArray()) {
49            int idx = c - 'a';
50            if (cur.ch[idx] == null) cur.ch[idx] = new TrieNode();
51            cur = cur.ch[idx];
52        }
53        if (cur.id == -1) {
54            cur.id = nextId;
55        }
56        map.put(s, cur.id);
57        return cur.id;
58    }
59    private long solve(int i, String s, String t, TrieNode root,
60                       long[][] dist, Long[] dp, long INF) {
61        int n = s.length();
62        if (i == n) return 0L;
63        if (dp[i] != null) return dp[i];
64        long best = INF;
65        if (s.charAt(i) == t.charAt(i)) {
66            long nxt = solve(i + 1, s, t, root, dist, dp, INF);
67            if (nxt < INF) best = nxt;
68        }
69        TrieNode ps = root, pt = root;
70        for (int j = i; j < n; j++) {
71            int cs = s.charAt(j) - 'a';
72            int ct = t.charAt(j) - 'a';
73            if (ps.ch[cs] == null || pt.ch[ct] == null) break;
74            ps = ps.ch[cs];
75            pt = pt.ch[ct];
76            if (ps.id != -1 && pt.id != -1) {
77                long cst = dist[ps.id][pt.id];
78                if (cst < INF) {
79                    long nxt = solve(j + 1, s, t, root, dist, dp, INF);
80                    if (nxt < INF) {
81                        long cand = cst + nxt;
82                        if (cand < best) best = cand;
83                    }
84                }
85            }
86        }
87        dp[i] = best;
88        return best;
89    }
90}
91