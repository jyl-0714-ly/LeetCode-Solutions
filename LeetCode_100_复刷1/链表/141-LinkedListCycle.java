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
        if(head == null || head.next == null){
            return false;
        }
        ListNode A = head;
        ListNode B = head.next;
        while(A != B){
            if(B == null || B.next == null){
                return false;
            }
            A = A.next;
            B = B.next.next;
        }
        return true;
    }
}