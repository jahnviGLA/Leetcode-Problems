// Last updated: 5/18/2026, 11:19:58 PM
1import java.util.*;
2
3class Solution {
4    public int minJumps(int[] arr) {
5        int n = arr.length;
6        if (n == 1) return 0;
7        Map<Integer, List<Integer>> map = new HashMap<>();
8        for (int i = 0; i < n; i++) {
9            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
10        }
11        Queue<Integer> queue = new LinkedList<>();
12        boolean[] visited = new boolean[n];
13        queue.offer(0);
14        visited[0] = true;
15        int steps = 0;
16        while (!queue.isEmpty()) {
17            int size = queue.size();
18            for (int s = 0; s < size; s++) {
19                int curr = queue.poll();
20                if (curr == n - 1) {
21                    return steps;
22                }
23                List<Integer> neighbors = map.get(arr[curr]);
24                if (curr + 1 < n) {
25                    neighbors.add(curr + 1);
26                }
27                if (curr - 1 >= 0) {
28                    neighbors.add(curr - 1);
29                }
30                for (int next : neighbors) {
31                    if (!visited[next]) {
32                        visited[next] = true;
33                        queue.offer(next);
34                    }
35                }
36                map.get(arr[curr]).clear();
37            }
38            steps++;
39        }
40        return -1;
41    }
42}