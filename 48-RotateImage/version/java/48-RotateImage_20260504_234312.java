// Last updated: 5/4/2026, 11:43:12 PM
1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4        for (int i = 0; i < n; i++) {
5            for (int j = i; j < n; j++) {
6                int temp = matrix[i][j];
7                matrix[i][j] = matrix[j][i];
8                matrix[j][i] = temp;
9            }
10        }
11        for (int i = 0; i < n; i++) {
12            int left = 0, right = n - 1;
13            while (left < right) {
14                int temp = matrix[i][left];
15                matrix[i][left] = matrix[i][right];
16                matrix[i][right] = temp;
17                left++;
18                right--;
19            }
20        }
21    }
22}