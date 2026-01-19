// Last updated: 1/19/2026, 1:17:01 PM
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int j = left; j <= right && num <= n * n; j++) {
                matrix[top][j] = num++;
            }
            top++;
            for (int i = top; i <= bottom && num <= n * n; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int j = right; j >= left && num <= n * n; j--) {
                matrix[bottom][j] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top && num <= n * n; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}
