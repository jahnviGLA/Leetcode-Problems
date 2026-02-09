// Last updated: 2/9/2026, 10:41:35 PM
1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12class Solution {
13    public ListNode detectCycle(ListNode head) {
14        if (head == null || head.next == null) return null;
15        ListNode slow = head;
16        ListNode fast = head;
17        while (fast != null && fast.next != null) {
18            slow = slow.next;
19            fast = fast.next.next;
20            if (slow == fast) {
21                slow = head;
22                while (slow != fast) {
23                    slow = slow.next;
24                    fast = fast.next;
25                }
26                return slow; 
27            }
28        }
29        return null; 
30    }
31}
32