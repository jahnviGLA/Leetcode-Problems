// Last updated: 1/22/2026, 11:28:16 AM
// this traversal question was done using recursion
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
17    public List<Integer> inorderTraversal(TreeNode root) {
18        List<Integer> res = new ArrayList<>();
19        helper(root, res);
20        return res;
21    }
22    private void helper(TreeNode node, List<Integer> list){
23        if(node==null){
24            return;
25        }
26        helper(node.left, list);
27        list.add(node.val);
28        helper(node.right, list);
29    }
30}