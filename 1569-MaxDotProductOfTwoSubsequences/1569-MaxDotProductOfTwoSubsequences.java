// Last updated: 1/19/2026, 1:15:02 PM
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int NEG_INF = -1000000000;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = NEG_INF;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int product = nums1[i] * nums2[j];
                int take = product;
                if (i > 0 && j > 0) {
                    take = product + Math.max(0, dp[i - 1][j - 1]);
                }
                int skip1 = (i > 0) ? dp[i - 1][j] : NEG_INF;
                int skip2 = (j > 0) ? dp[i][j - 1] : NEG_INF;
                dp[i][j] = Math.max(take, Math.max(skip1, skip2));
            }
        }
        return dp[n - 1][m - 1];
    }
}
