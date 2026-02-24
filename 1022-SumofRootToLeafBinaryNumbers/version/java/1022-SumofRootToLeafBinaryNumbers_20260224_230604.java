// Last updated: 2/24/2026, 11:06:04 PM
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
16/**
17 * Definition for a binary tree node.
18 * public class TreeNode {
19 *     int val;
20 *     TreeNode left;
21 *     TreeNode right;
22 *     TreeNode() {}
23 *     TreeNode(int val) { this.val = val; }
24 *     TreeNode(int val, TreeNode left, TreeNode right) {
25 *         this.val = val;
26 *         this.left = left;
27 *         this.right = right;
28 *     }
29 * }
30 */
31class Solution {    
32    public int sumRootToLeaf(TreeNode root) {
33        return dfs(root, 0);
34    }    
35    private int dfs(TreeNode node, int current) {
36        if (node == null) {
37            return 0;
38        }
39        current = (current << 1) | node.val;
40        if (node.left == null && node.right == null) {
41            return current;
42        }
43        return dfs(node.left, current) + dfs(node.right, current);
44    }
45}