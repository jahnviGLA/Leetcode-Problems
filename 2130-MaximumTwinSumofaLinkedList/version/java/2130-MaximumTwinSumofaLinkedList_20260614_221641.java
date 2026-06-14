// Last updated: 6/14/2026, 10:16:41 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public int pairSum(ListNode head) {
13        ArrayList<Integer> list = new ArrayList<>();
14        ListNode temp = head;
15        while(temp != null){
16            list.add(temp.val);
17            temp = temp.next;
18        }
19        int left = 0;
20        int right = list.size()-1;
21        int max = 0;
22        while(left < right){
23            int sum = list.get(left) + list.get(right);
24            max = Math.max(max, sum);
25            left++;
26            right--;
27        }
28        return max;
29    }
30}