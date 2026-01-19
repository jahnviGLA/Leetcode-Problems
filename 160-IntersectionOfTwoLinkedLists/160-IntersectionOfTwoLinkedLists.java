// Last updated: 1/19/2026, 1:16:06 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> s = new HashSet<>();
         while(headA!=null){
            s.add(headA);
            headA=headA.next;
         }
         while(headB!=null){
            if(s.contains(headB)==true){
                return headB;
            }
            s.add(headB);
            headB=headB.next;
         }
        return null;
    }
}