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
    /*
    题目：234.回文链表  
    对于1->2->3->2->1来说，然后得到其中间节点，而后对中间节点之后的进行反转，
    再以反转后得到的链表和前半段链表一一对比后，如果相等则是回文链表，反之不是。
    
    当为1->2->2->1这样的偶数的话，前半段会比后半段反转后的链表多一个，所以可以将后半段不为空为循环结束条件。
    */
    public boolean isPalindrome(ListNode head) {
        ListNode min = mid(head);
        ListNode rev = reverse(min);
        while(rev != null){
            if(head.val != rev.val){
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    
    //求中间节点
    public ListNode mid(ListNode head){
        ListNode min = head;
        ListNode right = head;
        while(right != null && right.next != null){
            min = min.next;
            right = right.next.next;
        }
        return min;
    }

    //反转链表
    public ListNode reverse(ListNode head){
        ListNode a = head;
        ListNode b = null;
        while(a != null){
            ListNode c = a.next;
            a.next = b;
            b = a;
            a = c;
        }
        return b;
    }
}