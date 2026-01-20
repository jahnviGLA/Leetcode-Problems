// Last updated: 1/20/2026, 10:57:55 PM
1import java.util.*;
2class Solution {
3    public double[] calcEquation(
4            List<List<String>> equations,
5            double[] values,
6            List<List<String>> queries) {
7        Map<String, Map<String, Double>> graph = new HashMap<>();
8
9        for (int i = 0; i < equations.size(); i++) {
10            String a = equations.get(i).get(0);
11            String b = equations.get(i).get(1);
12            double val = values[i];
13
14            graph.putIfAbsent(a, new HashMap<>());
15            graph.putIfAbsent(b, new HashMap<>());
16
17            graph.get(a).put(b, val);
18            graph.get(b).put(a, 1.0 / val);
19        }
20
21        double[] result = new double[queries.size()];
22
23        // Process queries
24        for (int i = 0; i < queries.size(); i++) {
25            String src = queries.get(i).get(0);
26            String dst = queries.get(i).get(1);
27
28            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
29                result[i] = -1.0;
30            } else if (src.equals(dst)) {
31                result[i] = 1.0;
32            } else {
33                result[i] = dfs(src, dst, 1.0, new HashSet<>(), graph);
34            }
35        }
36
37        return result;
38    }
39
40    private double dfs(String curr, String target, double product,
41                       Set<String> visited,
42                       Map<String, Map<String, Double>> graph) {
43
44        if (curr.equals(target)) return product;
45
46        visited.add(curr);
47
48        for (Map.Entry<String, Double> next : graph.get(curr).entrySet()) {
49            if (!visited.contains(next.getKey())) {
50                double res = dfs(
51                        next.getKey(),
52                        target,
53                        product * next.getValue(),
54                        visited,
55                        graph
56                );
57                if (res != -1.0) return res;
58            }
59        }
60
61        return -1.0;
62    }
63}
64