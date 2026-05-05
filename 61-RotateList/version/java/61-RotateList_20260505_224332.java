// Last updated: 5/5/2026, 10:43:32 PM
1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null || k == 0)
4            return head;
5
6        ListNode curr = head;
7        int n = 1;
8
9        while (curr.next != null) {
10            curr = curr.next;
11            n++;
12        }
13
14        curr.next = head;
15
16        k = k % n;
17
18        int stepsToNewTail = n - k;
19        ListNode newTail = head;
20
21        for (int i = 1; i < stepsToNewTail; i++) {
22            newTail = newTail.next;
23        }
24
25        ListNode newHead = newTail.next;
26        newTail.next = null;
27
28        return newHead;
29    }
30}