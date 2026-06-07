// Last updated: 6/8/2026, 1:16:06 AM
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
16
17class Solution {
18    public TreeNode createBinaryTree(int[][] descriptions) {
19        
20        HashMap<Integer, TreeNode> map = new HashMap<>();
21        HashSet<Integer> children = new HashSet<>();
22
23        for(int[] desc : descriptions) {
24            
25            int parent = desc[0];
26            int child = desc[1];
27            int isLeft = desc[2];
28
29            // create parent node if missing
30            if(!map.containsKey(parent)) {
31                map.put(parent, new TreeNode(parent));
32            }
33
34            // create child node if missing
35            if(!map.containsKey(child)) {
36                map.put(child, new TreeNode(child));
37            }
38
39            TreeNode parentNode = map.get(parent);
40            TreeNode childNode = map.get(child);
41
42            // connect nodes
43            if(isLeft == 1) {
44                parentNode.left = childNode;
45            }
46            else {
47                parentNode.right = childNode;
48            }
49
50            // child cannot be root
51            children.add(child);
52        }
53
54
55        // find node that never appeared as child
56        for(int value : map.keySet()) {
57            if(!children.contains(value)) {
58                return map.get(value);
59            }
60        }
61
62        return null;
63    }
64}