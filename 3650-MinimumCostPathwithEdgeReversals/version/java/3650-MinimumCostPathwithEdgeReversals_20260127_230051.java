// Last updated: 1/27/2026, 11:00:51 PM
1import java.util.*;
2
3class Solution {
4    public int minCost(int n, int[][] edges) {
5        List<int[]>[] graph = new List[n];
6        List<int[]>[] revGraph = new List[n];
7        for (int i = 0; i < n; i++) {
8            graph[i] = new ArrayList<>();
9            revGraph[i] = new ArrayList<>();
10        }
11        for (int[] e : edges) {
12            int u = e[0], v = e[1], w = e[2];
13            graph[u].add(new int[]{v, w});
14            revGraph[v].add(new int[]{u, w});
15        }
16        
17        long[] dist = new long[2 * n];
18        Arrays.fill(dist, Long.MAX_VALUE / 2);
19        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
20        dist[0] = 0;
21        pq.offer(new long[]{0, 0});
22        
23        while (!pq.isEmpty()) {
24            long[] top = pq.poll();
25            long cost = top[0];
26            int state = (int) top[1];
27            int u = state / 2;
28            int used = state % 2;
29            if (cost > dist[state]) continue;
30            
31            // Normal outgoing
32            for (int[] ne : graph[u]) {
33                int v = ne[0], w = ne[1];
34                int nstate = v * 2 + used;
35                long nc = cost + w;
36                if (nc < dist[nstate]) {
37                    dist[nstate] = nc;
38                    pq.offer(new long[]{nc, nstate});
39                }
40            }
41            
42            // Switch reverse incoming (if not used at u)
43            if (used == 0) {
44                for (int[] re : revGraph[u]) {
45                    int v = re[0], w = re[1];
46                    int nstate = v * 2 + 0;  // arrive v, switch at v unused
47                    long nc = cost + 2L * w;
48                    if (nc < dist[nstate]) {
49                        dist[nstate] = nc;
50                        pq.offer(new long[]{nc, nstate});
51                    }
52                }
53            }
54        }
55        
56        long ans = Math.min(dist[2*(n-1)], dist[2*(n-1) + 1]);
57        return ans >= Long.MAX_VALUE / 2 ? -1 : (int) ans;
58    }
59}
60