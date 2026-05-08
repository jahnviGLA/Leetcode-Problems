// Last updated: 5/8/2026, 11:32:31 PM
1import java.util.*;
2class Solution {
3    public int minJumps(int[] nums) {
4        int n = nums.length;
5        if (n == 1) return 0;
6
7        Map<Integer, List<Integer>> divisibleMap = new HashMap<>();
8        for (int i = 0; i < n; i++) {
9            List<Integer> factors = getPrimeFactors(nums[i]);
10            for (int p : factors) {
11                divisibleMap.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
12            }
13        }
14        Queue<Integer> q = new LinkedList<>();
15        boolean[] visited = new boolean[n];
16        Set<Integer> usedPrime = new HashSet<>();
17        q.offer(0);
18        visited[0] = true;
19        int steps = 0;
20        while (!q.isEmpty()) {
21            int size = q.size();
22            while (size-- > 0) {
23                int idx = q.poll();
24                if (idx == n - 1) return steps;
25                if (idx - 1 >= 0 && !visited[idx - 1]) {
26                    visited[idx - 1] = true;
27                    q.offer(idx - 1);
28                }
29                if (idx + 1 < n && !visited[idx + 1]) {
30                    visited[idx + 1] = true;
31                    q.offer(idx + 1);
32                }
33                if (isPrime(nums[idx])) {
34                    int p = nums[idx];
35                    if (!usedPrime.contains(p)) {
36                        usedPrime.add(p);
37                        List<Integer> nextIndices = divisibleMap.getOrDefault(p, new ArrayList<>());
38                        for (int next : nextIndices) {
39                            if (!visited[next]) {
40                                visited[next] = true;
41                                q.offer(next);
42                            }
43                        }
44                    }
45                }
46            }
47            steps++;
48        }
49        return -1;
50    }
51    private boolean isPrime(int x) {
52        if (x < 2) return false;
53        for (int i = 2; i * i <= x; i++) {
54            if (x % i == 0) return false;
55        }
56        return true;
57    }
58    private List<Integer> getPrimeFactors(int x) {
59        List<Integer> factors = new ArrayList<>();
60        for (int p = 2; p * p <= x; p++) {
61            if (x % p == 0) {
62                factors.add(p);
63                while (x % p == 0) {
64                    x /= p;
65                }
66            }
67        }
68        if (x > 1) {
69            factors.add(x);
70        }
71        return factors;
72    }
73}