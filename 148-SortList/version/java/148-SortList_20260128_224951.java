// Last updated: 1/28/2026, 10:49:51 PM
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
12    public ListNode sortList(ListNode head) {
13        if (head == null || head.next == null) {
14            return head;
15        }
16        ListNode mid = getMid(head);
17        ListNode rightHead = mid.next;
18        mid.next = null;
19        ListNode left = sortList(head);
20        ListNode right = sortList(rightHead);
21        return merge(left, right);
22    }
23    private ListNode getMid(ListNode head) {
24        ListNode slow = head, fast = head.next;
25        while (fast != null && fast.next != null) {
26            slow = slow.next;
27            fast = fast.next.next;
28        }
29        return slow;
30    }
31    private ListNode merge(ListNode l1, ListNode l2) {
32        ListNode dummy = new ListNode(0);
33        ListNode curr = dummy;
34        while (l1 != null && l2 != null) {
35            if (l1.val <= l2.val) {
36                curr.next = l1;
37                l1 = l1.next;
38            } else {
39                curr.next = l2;
40                l2 = l2.next;
41            }
42            curr = curr.next;
43        }
44        curr.next = (l1 != null) ? l1 : l2;
45        return dummy.next;
46    }
47}
48