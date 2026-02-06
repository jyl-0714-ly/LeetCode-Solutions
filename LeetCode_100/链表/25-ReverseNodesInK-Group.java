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
    题目：25.K个一组翻转链表        
    给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
    
    k是一个正整数,它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
    
    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        /*
        思路：通过分组反转链表实现每 k 个节点一组的反转：首先统计链表总长度，确保剩余节点数 ≥ k 才进行
        反转；使用 dummy 节点统一处理头节点变更，每组内采用标准三指针反转法（pre、cur、nxt），反转后将前
        一段的尾部（p0）连接到新反转段的头部，并更新 p0 指向当前段原头部（现尾部），最后返回 dummy.next。
        */
        // 统计节点个数
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

        // k 个一组处理
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre; // 每次循环只修改一个 next，方便大家理解
                pre = cur;
                cur = nxt;
            }

            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
}