// Last updated: 4/21/2026, 11:12:17 PM
1import java.util.*;
2class Solution {
3    class DSU {
4        int[] parent;
5        DSU(int n) {
6            parent = new int[n];
7            for (int i = 0; i < n; i++) parent[i] = i;
8        } 
9        int find(int x) {
10            if (parent[x] != x)
11                parent[x] = find(parent[x]); 
12            return parent[x];
13        }
14        
15        void union(int a, int b) {
16            int pa = find(a);
17            int pb = find(b);
18            if (pa != pb) parent[pa] = pb;
19        }
20    }
21    
22    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
23        int n = source.length;
24        DSU dsu = new DSU(n);
25        for (int[] swap : allowedSwaps) {
26            dsu.union(swap[0], swap[1]);
27        }
28        Map<Integer, List<Integer>> groups = new HashMap<>();
29        
30        for (int i = 0; i < n; i++) {
31            int parent = dsu.find(i);
32            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
33        }
34        
35        int mismatch = 0;
36        for (List<Integer> group : groups.values()) {
37            Map<Integer, Integer> freq = new HashMap<>();
38            for (int idx : group) {
39                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
40            }
41            for (int idx : group) {
42                if (freq.getOrDefault(target[idx], 0) > 0) {
43                    freq.put(target[idx], freq.get(target[idx]) - 1);
44                } else {
45                    mismatch++;
46                }
47            }
48        }
49        
50        return mismatch;
51    }
52}