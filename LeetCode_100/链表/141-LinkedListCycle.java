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
    题目：141.环形链表  
    给你一个链表的头节点head，判断链表中是否有环。
    */
    public boolean hasCycle(ListNode head) {
        /*
        思路：运用快慢指针，如果存在环的话，那么快指针和慢指针必定会在这个环里打转，
        但由于每次快指针都要比慢指针多走一步，所以势必会追上，因此可通过快慢指针是否相等来判断是否存在环。
        如果不存在环的话，那么快指针势必会先为null，则可以运用这个条件来终止循环，判断链表没有环。
        */

        //提前排除链表过短，造成下面.next.next的空指针异常。
        if(head == null || head.next == null){
            return false;
        }

        //定义快慢指针
        ListNode A = head;
        ListNode B = head.next;

        //当快慢指针相等时，循环停止，返回true
        while(A != B){
            if(B == null || B.next == null){//因为如果没有环的话，快指针必定现为null，故当快指针为null时返回false
                return false;
            }
            A = A.next;//慢指针移动
            B = B.next.next;//快指针移动
        }
        return true;
    }
}