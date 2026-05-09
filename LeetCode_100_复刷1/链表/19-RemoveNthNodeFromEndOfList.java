/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode A = head;
        ListNode B = pre;
        for(int i = 0; i < n; i++){
            A = A.next;
        }
        while(A != null){
            A = A.next;
            B = B.next;
        }
        B.next = B.next.next;
        return pre.next;
    }
}