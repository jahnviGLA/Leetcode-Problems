// Last updated: 3/4/2026, 10:36:53 PM
1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int[] row = new int[m];
7        int[] col = new int[n];
8        for(int i = 0; i < m; i++) {
9            for(int j = 0; j < n; j++) {
10                if(mat[i][j] == 1) {
11                    row[i]++;
12                    col[j]++;
13                }
14            }
15        }
16
17        int count = 0;
18
19        // Check special positions
20        for(int i = 0; i < m; i++) {
21            for(int j = 0; j < n; j++) {
22                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
23                    count++;
24                }
25            }
26        }
27
28        return count;
29    }
30}