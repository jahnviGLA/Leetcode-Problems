// Last updated: 1/27/2026, 11:10:47 PM
1import java.util.*;
2class Solution {
3    public int minCost(int n, int[][] edges) {
4        List<int[]>[] graph = new List[n];
5        List<int[]>[] revGraph = new List[n];
6        for (int i = 0; i < n; i++) {
7            graph[i] = new ArrayList<>();
8            revGraph[i] = new ArrayList<>();
9        }
10        for (int[] e : edges) {
11            int u = e[0], v = e[1], w = e[2];
12            graph[u].add(new int[]{v, w});
13            revGraph[v].add(new int[]{u, w});
14        }
15        long[] dist = new long[2 * n];
16        Arrays.fill(dist, Long.MAX_VALUE / 2);
17        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
18        dist[0] = 0;
19        pq.offer(new long[]{0, 0});
20        while (!pq.isEmpty()) {
21            long[] top = pq.poll();
22            long cost = top[0];
23            int state = (int) top[1];
24            int u = state / 2;
25            int used = state % 2;
26            if (cost > dist[state]) continue;
27            for (int[] ne : graph[u]) {
28                int v = ne[0], w = ne[1];
29                int nstate = v * 2 + used;
30                long nc = cost + w;
31                if (nc < dist[nstate]) {
32                    dist[nstate] = nc;
33                    pq.offer(new long[]{nc, nstate});
34                }
35            }
36            if (used == 0) {
37                for (int[] re : revGraph[u]) {
38                    int v = re[0], w = re[1];
39                    int nstate = v * 2 + 0; 
40                    long nc = cost + 2L * w;
41                    if (nc < dist[nstate]) {
42                        dist[nstate] = nc;
43                        pq.offer(new long[]{nc, nstate});
44                    }
45                }
46            }
47        }
48        
49        long ans = Math.min(dist[2*(n-1)], dist[2*(n-1) + 1]);
50        return ans >= Long.MAX_VALUE / 2 ? -1 : (int) ans;
51    }
52}
53