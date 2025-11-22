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
    题目：206.反转链表      
    给你单链表的头节点head，请你反转链表，并返回反转后的链表。
    */
    public ListNode reverseList(ListNode head) {
    /*
    思路：为了实现反转，将当前节点的next指针改为指向前一个节点。由于节点的next改变，为了不丧失指向节点的地址，
        因此必须事先存储其原本指向的节点。
    */
        ListNode a = head; // a 指向当前节点，从头开始
        ListNode b = null; // b 指向已反转部分的头，初始为空（反转后尾部指向 null）

        while (a != null) {         // 只要还有节点没处理
            ListNode c = a.next;    // ① 先保存 a 的下一个节点（防止丢失）
            a.next = b;             // ② 把 a 的 next 指向 b（实现“反转”）
            b = a;                  // ③ b 前进一步：现在 a 成为已反转部分的新头
            a = c;                  // ④ a 前进一步：处理下一个节点
        }

        return b; // 最后 b 就是反转后的新头节点
    }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        /*
        思路：递归方法，递归结束条件head == null || head.next == null。
        不断地使当前节点的下一个节点指向当前节点，同时使当前节点指向空，
        利用递归结束条件，将最后一个节点记录下来，准备当做反转后的头节点。
        */
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);//记录下反转前的最后一个节点
        head.next.next = head;//使当前节点的下一个节点指向当前节点
        head.next = null;//将当前节点指向空，以此断掉当前节点和当前节点的下一个节点之间的双向链接
        return newHead;//返回反转前的最后一个节点，即反转后的头节点
    }
}