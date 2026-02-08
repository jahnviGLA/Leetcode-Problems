// Last updated: 2/8/2026, 10:36:15 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean isBalanced(TreeNode root) {
18        return height(root) != -1;
19    }
20    private int height(TreeNode node) {
21        if (node == null) return 0;
22        int left = height(node.left);
23        if (left == -1) return -1;
24        int right = height(node.right);
25        if (right == -1) return -1;
26        if (Math.abs(left - right) > 1) return -1;
27        return 1 + Math.max(left, right);
28    }
29}
30