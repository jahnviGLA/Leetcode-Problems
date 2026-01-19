// Last updated: 1/19/2026, 1:16:12 PM
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> s= new HashSet<>();
        while(head!=null){
            if(s.contains(head)==true){
                return true;
            }
            s.add(head);
            head=head.next;
        }
        return false;
    }
}