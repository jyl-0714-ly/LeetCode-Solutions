/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    题目：160.相交链表  
    给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回null。

    注：题目数据保证整个链式结构中不存在环；函数返回结果后，链表必须保持其原始结构。
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
        思路：因为需要求相交链表的交点，链表A到交点举例位a-c个节点，链表B到交点举例b-c个节点，
        链表A和链表B每次都能够移动一个节点，因为a和b可能不相等，所以不一定同时到达交点出，
        但是(a-c)+(b-c) = a+b，这个是一定的，所以可以这样做：
        当指针A遍历过一次链表A后，立马到链表B的开头开始遍历；
        与此同时，当指针B遍历过一次链表B的时候，立马到链表A的开头开始遍历。
        这样可以同时到达交点处，如果没有交点，那指针A也到达链表B末尾，指向null；同时指针B到达链表A末尾，指向null。
        */
        ListNode A = headA;
        ListNode B = headB;
        //当指针A和指针B相等时，只有可能在交点或链表A和链表B都遍历过，最后都指向null这两种时候。
        while(A != B){
            //A=当A第一次为空时，说明遍历完了链表A，此时指向链表B开头，否则就是指向链表A的下一个节点。
            A = A == null ? headB : A.next;
            //B=当B第一次为空时，说明遍历完了链表B，此时指向链表A开头，否则就是指向链表B的下一个节点。
            B = B == null ? headA : B.next;
        }
        return A;
    }
}