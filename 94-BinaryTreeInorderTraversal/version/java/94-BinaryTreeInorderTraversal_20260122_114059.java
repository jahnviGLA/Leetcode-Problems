// Last updated: 1/22/2026, 11:40:59 AM
// this tree traversal question is done by iterative method
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
18        List<Integer> res= new ArrayList<>();
19        Stack <TreeNode> stack = new Stack<>();
20        TreeNode curr= root;
21        while(curr != null || !stack.isEmpty()){
22            while(curr!=null){
23                stack.push(curr);
24                curr=curr.left;
25            }
26            curr=stack.pop();
27            res.add(curr.val);
28            curr= curr.right;
29        }
30        return res;
31    }
32}