// Last updated: 3/24/2026, 10:23:44 PM
1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        int size = n * m;
6        int MOD = 12345;
7
8        int[] arr = new int[size];
9
10        // Step 1: flatten
11        int idx = 0;
12        for (int[] row : grid) {
13            for (int val : row) {
14                arr[idx++] = val % MOD;
15            }
16        }
17
18        // Step 2: prefix
19        int[] prefix = new int[size];
20        prefix[0] = 1;
21        for (int i = 1; i < size; i++) {
22            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
23        }
24
25        // Step 3: suffix
26        int[] suffix = new int[size];
27        suffix[size - 1] = 1;
28        for (int i = size - 2; i >= 0; i--) {
29            suffix[i] = (suffix[i + 1] * arr[i + 1]) % MOD;
30        }
31
32        // Step 4: build result
33        int[][] result = new int[n][m];
34        idx = 0;
35
36        for (int i = 0; i < n; i++) {
37            for (int j = 0; j < m; j++) {
38                result[i][j] = (prefix[idx] * suffix[idx]) % MOD;
39                idx++;
40            }
41        }
42
43        return result;
44    }
45}