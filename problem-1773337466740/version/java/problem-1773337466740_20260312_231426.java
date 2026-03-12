// Last updated: 3/12/2026, 11:14:26 PM
1import java.util.*;
2
3class Solution {
4
5    class DSU {
6        int[] parent, rank;
7        
8        DSU(int n){
9            parent = new int[n];
10            rank = new int[n];
11            for(int i=0;i<n;i++) parent[i] = i;
12        }
13        
14        int find(int x){
15            if(parent[x] != x)
16                parent[x] = find(parent[x]);
17            return parent[x];
18        }
19        
20        boolean union(int a, int b){
21            int pa = find(a);
22            int pb = find(b);
23            
24            if(pa == pb) return false;
25            
26            if(rank[pa] < rank[pb]) parent[pa] = pb;
27            else if(rank[pb] < rank[pa]) parent[pb] = pa;
28            else{
29                parent[pb] = pa;
30                rank[pa]++;
31            }
32            return true;
33        }
34    }
35
36    public int maxStability(int n, int[][] edges, int k) {
37        
38        int low = 0, high = 200000, ans = -1;
39
40        while(low <= high){
41            int mid = (low + high) / 2;
42            
43            if(can(n, edges, k, mid)){
44                ans = mid;
45                low = mid + 1;
46            } else {
47                high = mid - 1;
48            }
49        }
50        
51        return ans;
52    }
53
54    private boolean can(int n, int[][] edges, int k, int x){
55
56        DSU dsu = new DSU(n);
57        int used = 0;
58
59        List<int[]> normal = new ArrayList<>();
60        List<int[]> upgrade = new ArrayList<>();
61
62        for(int[] e : edges){
63            int u = e[0], v = e[1], s = e[2], must = e[3];
64
65            if(must == 1){
66                if(s < x) return false;
67
68                if(!dsu.union(u,v)) return false;
69                used++;
70            } else {
71
72                if(s >= x)
73                    normal.add(e);
74                else if(2*s >= x)
75                    upgrade.add(e);
76            }
77        }
78
79        for(int[] e : normal){
80            if(dsu.union(e[0], e[1])){
81                used++;
82            }
83        }
84
85        int upgrades = 0;
86
87        for(int[] e : upgrade){
88            if(used == n-1) break;
89
90            if(dsu.union(e[0], e[1])){
91                upgrades++;
92                used++;
93                if(upgrades > k) return false;
94            }
95        }
96
97        return used == n-1;
98    }
99}