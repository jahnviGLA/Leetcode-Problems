// Last updated: 3/22/2026, 10:31:28 PM
1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        for (int i = 0; i < 4; i++) {
4            if (isEqual(mat, target)) return true;
5            rotate(mat);
6        }
7        return false;
8    }
9    private void rotate(int[][] mat) {
10        int n = mat.length;
11        for (int i = 0; i < n; i++) {
12            for (int j = i; j < n; j++) {
13                int temp = mat[i][j];
14                mat[i][j] = mat[j][i];
15                mat[j][i] = temp;
16            }
17        }
18        for (int i = 0; i < n; i++) {
19            int left = 0, right = n - 1;
20            while (left < right) {
21                int temp = mat[i][left];
22                mat[i][left] = mat[i][right];
23                mat[i][right] = temp;
24                left++;
25                right--;
26            }
27        }
28    }
29    private boolean isEqual(int[][] a, int[][] b) {
30        int n = a.length;
31        for (int i = 0; i < n; i++) {
32            for (int j = 0; j < n; j++) {
33                if (a[i][j] != b[i][j]) return false;
34            }
35        }
36        return true;
37    }
38}