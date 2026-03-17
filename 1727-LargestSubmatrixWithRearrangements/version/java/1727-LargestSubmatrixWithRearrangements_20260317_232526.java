// Last updated: 3/17/2026, 11:25:26 PM
1import java.util.*;
2class Solution {
3    public int largestSubmatrix(int[][] matrix) {
4        int m = matrix.length;
5        int n = matrix[0].length;
6        for (int i = 1; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (matrix[i][j] != 0) {
9                    matrix[i][j] += matrix[i - 1][j];
10                }
11            }
12        }
13        int maxArea = 0;
14        for (int i = 0; i < m; i++) {
15            int[] row = Arrays.copyOf(matrix[i], n);
16            Arrays.sort(row);
17            for (int j = n - 1; j >= 0; j--) {
18                int height = row[j];
19                int width = n - j;
20                maxArea = Math.max(maxArea, height * width);
21            }
22        }
23        return maxArea;
24    }
25}