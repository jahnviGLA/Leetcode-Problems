// Last updated: 1/23/2026, 11:02:31 PM
1class Solution {
2    static final int MOD = 1_000_000_007;
3    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
4        long[][] prev = new long[m][n];
5        prev[startRow][startColumn] = 1;
6        long result = 0;
7        int[] dx = {1, -1, 0, 0};
8        int[] dy = {0, 0, 1, -1};
9        for (int move = 1; move <= maxMove; move++) {
10            long[][] curr = new long[m][n];
11            for (int i = 0; i < m; i++) {
12                for (int j = 0; j < n; j++) {
13                    if (prev[i][j] == 0) continue;
14                    for (int d = 0; d < 4; d++) {
15                        int ni = i + dx[d];
16                        int nj = j + dy[d];
17                        if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
18                            result = (result + prev[i][j]) % MOD;
19                        } else {
20                            curr[ni][nj] = (curr[ni][nj] + prev[i][j]) % MOD;
21                        }
22                    }
23                }
24            }
25            prev = curr;
26        }
27        return (int) result;
28    }
29}
30