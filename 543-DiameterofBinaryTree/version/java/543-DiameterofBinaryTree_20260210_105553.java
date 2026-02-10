// Last updated: 2/10/2026, 10:55:53 AM
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
17    private int maxDiameter = 0;
18    public int diameterOfBinaryTree(TreeNode root) {
19        depth(root);
20        return maxDiameter;
21    }
22    private int depth(TreeNode node) {
23        if (node == null) return 0;
24        int left = depth(node.left);
25        int right = depth(node.right);
26        maxDiameter = Math.max(maxDiameter, left + right);
27        return Math.max(left, right) + 1;
28    }
29}
30