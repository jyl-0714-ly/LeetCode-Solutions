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
    题目：148.排序链表      
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    */
    public ListNode sortList(ListNode head) {
        /*
        思路：归并排序（递归+快慢指针找中点+链表合并）
        利用快慢指针找中点将链表一半一半的递归切割，然后利用链表合并时，对比大小，将其排序链表片段排序，最后得到的就是排序后的链表。
        */
        if(head == null || head.next == null){
            return head;
        }
        ListNode head2 = middleNode(head);
        head = sortList(head);
        head2 = sortList(head2);
        return mergeTwoLists(head, head2);
    }
    private ListNode middleNode(ListNode head){
        //快慢指针找中点，切割链表
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            pre = slow;//记录中点的前一个点
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;//分割开
        return slow;
    }
    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();//哨兵结点
        ListNode cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){//较小的结点先连接到哨兵节点上
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;//把对比后剩余的连接起来
        return dummy.next;
    }
}