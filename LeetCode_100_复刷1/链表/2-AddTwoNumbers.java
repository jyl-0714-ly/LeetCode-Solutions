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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        while(l1 != null || l2 != null){
            int m = l1 == null ? 0 : l1.val;
            int n = l2 == null ? 0 : l2.val;
            int num = m + n + count;
            count = 0;
            if(num >= 10){
                count++;
            }
            int sum = num%10;
            head.next = new ListNode(sum);
            if(l1 != null)  l1 = l1.next;
            if(l2 != null)  l2 = l2.next;
            head = head.next;
        }
        if(count != 0)  head.next = new ListNode(1);
        return pre.next;
    }
}