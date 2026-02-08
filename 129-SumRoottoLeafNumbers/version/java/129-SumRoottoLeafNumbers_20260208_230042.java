// Last updated: 2/8/2026, 11:00:42 PM
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
17    public int sumNumbers(TreeNode root) {
18        return dfs(root, 0);
19    }
20    private int dfs(TreeNode node, int currentSum) {
21        if (node == null) return 0;
22        currentSum = currentSum * 10 + node.val;
23        if (node.left == null && node.right == null) {
24            return currentSum;
25        }
26        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
27    }
28}
29