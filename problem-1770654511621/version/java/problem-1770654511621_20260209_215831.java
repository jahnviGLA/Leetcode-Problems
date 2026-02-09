// Last updated: 2/9/2026, 9:58:31 PM
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
17    private List<Integer> inorder = new ArrayList<>();
18    public TreeNode balanceBST(TreeNode root) {
19        inorderTraversal(root);
20        return buildBST(0, inorder.size() - 1);
21    }
22    private void inorderTraversal(TreeNode node) {
23        if (node == null) return;
24        inorderTraversal(node.left);
25        inorder.add(node.val);
26        inorderTraversal(node.right);
27    }
28    private TreeNode buildBST(int left, int right) {
29        if (left > right) return null;
30        int mid = left + (right - left) / 2;
31        TreeNode root = new TreeNode(inorder.get(mid));
32        root.left = buildBST(left, mid - 1);
33        root.right = buildBST(mid + 1, right);
34        return root;
35    }
36}
37