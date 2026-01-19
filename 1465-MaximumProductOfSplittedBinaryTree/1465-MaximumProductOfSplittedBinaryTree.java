// Last updated: 1/19/2026, 1:15:06 PM
class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        computeSubtreeSum(root);
        return (int)(maxProduct % MOD);
    }
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }
    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;
        long leftSum = computeSubtreeSum(node.left);
        long rightSum = computeSubtreeSum(node.right);
        long subtreeSum = node.val + leftSum + rightSum;
        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subtreeSum;
    }
}
