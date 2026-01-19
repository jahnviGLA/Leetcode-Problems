// Last updated: 1/19/2026, 10:53:46 PM
1class Solution {
2    public int maxSideLength(int[][] mat, int threshold) {
3        int m = mat.length, n = mat[0].length;
4        int[][] pre = new int[m + 1][n + 1];
5        for (int i = 1; i <= m; i++) {
6            for (int j = 1; j <= n; j++) {
7                pre[i][j] = mat[i - 1][j - 1]
8                          + pre[i - 1][j]
9                          + pre[i][j - 1]
10                          - pre[i - 1][j - 1];
11            }
12        }
13        int left = 1, right = Math.min(m, n);
14        int ans = 0;
15        while (left <= right) {
16            int mid = (left + right) / 2;
17            if (existsSquare(pre, m, n, mid, threshold)) {
18                ans = mid;
19                left = mid + 1;   
20            } else {
21                right = mid - 1; 
22            }
23        }
24        return ans;
25    }
26    private boolean existsSquare(int[][] pre, int m, int n, int k, int threshold) {
27        for (int i = 0; i + k <= m; i++) {
28            for (int j = 0; j + k <= n; j++) {
29                int sum = pre[i + k][j + k]
30                        - pre[i][j + k]
31                        - pre[i + k][j]
32                        + pre[i][j];
33                if (sum <= threshold) return true;
34            }
35        }
36        return false;
37    }
38}
39