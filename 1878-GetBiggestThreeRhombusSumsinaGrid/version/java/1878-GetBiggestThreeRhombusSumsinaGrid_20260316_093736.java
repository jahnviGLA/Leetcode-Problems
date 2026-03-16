// Last updated: 3/16/2026, 9:37:36 AM
1import java.util.*;
2
3class Solution {
4    public int[] getBiggestThree(int[][] grid) {
5
6        int m = grid.length;
7        int n = grid[0].length;
8
9        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
10
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13
14                // radius 0 rhombus
15                set.add(grid[i][j]);
16
17                for (int k = 1; ; k++) {
18
19                    if (i-k < 0 || i+k >= m || j-k < 0 || j+k >= n)
20                        break;
21
22                    int sum = 0;
23
24                    int r = i-k;
25                    int c = j;
26
27                    // top -> right
28                    for (int t = 0; t < k; t++)
29                        sum += grid[r+t][c+t];
30
31                    // right -> bottom
32                    for (int t = 0; t < k; t++)
33                        sum += grid[r+k+t][c+k-t];
34
35                    // bottom -> left
36                    for (int t = 0; t < k; t++)
37                        sum += grid[r+2*k-t][c-t];
38
39                    // left -> top
40                    for (int t = 0; t < k; t++)
41                        sum += grid[r+k-t][c-k+t];
42
43                    set.add(sum);
44                }
45            }
46        }
47
48        int size = Math.min(3, set.size());
49        int[] ans = new int[size];
50
51        int i = 0;
52        for (int val : set) {
53            ans[i++] = val;
54            if (i == size) break;
55        }
56
57        return ans;
58    }
59}