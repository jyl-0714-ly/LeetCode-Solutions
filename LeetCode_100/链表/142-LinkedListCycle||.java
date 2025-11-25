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
    /*
    题目：142.环形链表||  
    给定一个链表的头节点head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
    */
    public ListNode detectCycle(ListNode head) {
        /*
        思路：求环形链表（141.环形链表）已经做过了，这道题的关键在于：
        “从链表头到环入口的距离，等于从相遇点到环入口的距离”这个定理。

        也就是说，在通过快慢指针判断出是否为环形链表之后，相遇点也求出来了，则可通过这句话，求环入口。
        */
        if(head == null || head.next == null){
            return null;
        }
        //定义快慢指针
        ListNode A = head;
        ListNode B = head;
        //当快指针为空的时候，则必定不是环形链表，返回null
        while(B != null && B.next != null){
            //使快慢指针移动
            A = A.next;
            B = B.next.next;
            //得到相遇点
            if(A == B){
                //已知相遇点A，再定义一个链表头
                ListNode C = head;
                //当链表头和相遇点除指针，以慢指针速度移动，再次相遇时，即为环入口
                while(C != A){
                    C = C.next;
                    A = A.next;
                }
                return A;
            }
        }
        return null;
    }
}