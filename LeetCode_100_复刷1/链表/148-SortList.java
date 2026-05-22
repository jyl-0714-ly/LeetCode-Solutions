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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = mid(head);
        head = sortList(head);
        node = sortList(node);
        return sort(head,node);
    }
    private ListNode mid(ListNode head){
        ListNode A = head;
        ListNode B = head;
        while(B.next != null && B.next.next != null){
            A = A.next;
            B = B.next.next;
        }
        ListNode C = A.next;
        A.next = null;
        return C;
    }
    private ListNode sort(ListNode head, ListNode node){
        if(head == null) return node;
        if(node == null) return head;
        if(head.val < node.val){
            head.next = sort(head.next, node);
            return head;
        }
        node.next = sort(head, node.next);
        return node;
    }
}