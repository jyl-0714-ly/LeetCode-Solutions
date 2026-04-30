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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = midOne(head);
        ListNode rev = reverse(mid);
        while(rev != null){
            if(head.val != rev.val){
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    //找到中间节点
    public ListNode midOne(ListNode head){
        ListNode left = head;
        ListNode right = head;
        while(right != null && right.next != null){
            left = left.next;
            right = right.next.next;
        }
        return left;
    }
    //中间节点之后的节点反转
    public ListNode reverse(ListNode head){
        ListNode A = head;
        ListNode B = null;
        while(A != null){
            ListNode C = A.next;
            A.next = B;
            B = A;
            A = C;
        }
        return B;
    }
}