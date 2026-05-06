// Last updated: 5/6/2026, 6:19:43 PM
1class Solution {
2    public char[][] rotateTheBox(char[][] boxGrid) {
3        int m = boxGrid.length;
4        int n = boxGrid[0].length;
5        for (int i = 0; i < m; i++) {
6            int empty = n - 1;
7            for (int j = n - 1; j >= 0; j--) {
8                if (boxGrid[i][j] == '*') {
9                    empty = j - 1;
10                }
11                else if (boxGrid[i][j] == '#') {
12                    boxGrid[i][j] = '.';
13                    boxGrid[i][empty] = '#';
14                    empty--;
15                }
16            }
17        }
18        char[][] ans = new char[n][m];
19        for (int i = 0; i < m; i++) {
20            for (int j = 0; j < n; j++) {
21
22                ans[j][m - 1 - i] = boxGrid[i][j];
23            }
24        }
25        return ans;
26    }
27}