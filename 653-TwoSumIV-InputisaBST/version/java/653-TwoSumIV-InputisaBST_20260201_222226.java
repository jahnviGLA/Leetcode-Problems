// Last updated: 2/1/2026, 10:22:26 PM
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
17    List<Integer> list = new ArrayList<>();
18    public boolean findTarget(TreeNode root, int k) {
19        inorder(root);
20        int left = 0, right = list.size() - 1;
21        while (left < right) {
22            int sum = list.get(left) + list.get(right);
23            if (sum == k) return true;
24            else if (sum < k) left++;
25            else right--;
26        }
27        return false;
28    }
29    private void inorder(TreeNode root) {
30        if (root == null) return;
31        inorder(root.left);
32        list.add(root.val);
33        inorder(root.right);
34    }
35}
36