// Last updated: 3/27/2026, 7:47:55 PM
1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int shift = k % n;
7
8        // If no effective shift → matrix unchanged
9        if (shift == 0) return true;
10
11        for (int i = 0; i < m; i++) {
12            // Check if this row changes after shift
13            for (int j = 0; j < n; j++) {
14                int newIndex;
15
16                if (i % 2 == 0) {
17                    // even row → left shift
18                    newIndex = (j + shift) % n;
19                } else {
20                    // odd row → right shift
21                    newIndex = (j - shift + n) % n;
22                }
23
24                if (mat[i][j] != mat[i][newIndex]) {
25                    return false;
26                }
27            }
28        }
29
30        return true;
31    }
32}