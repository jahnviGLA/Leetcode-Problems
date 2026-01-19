// Last updated: 1/19/2026, 1:16:24 PM
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
