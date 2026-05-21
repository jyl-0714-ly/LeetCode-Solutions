// 迭代

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
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0,head);
        ListNode node0 = pre;
        ListNode node1 = head;
        while(node1 != null && node1.next != null){
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            
            node0.next = node2;
            node2.next = node1;
            node1.next = node3;

            node0 = node1;
            node1 = node3;
        }
        return pre.next;
    }
}

// 递归

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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = node2.next;

        node1.next = swapPairs(node3);
        node2.next = node1;
        return node2;
    }
}