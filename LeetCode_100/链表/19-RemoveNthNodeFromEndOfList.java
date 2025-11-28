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
    题目：19.删除链表的倒数第N个结点        
    给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        思路：计算链表长度
        首先，要删除一个节点B，那么必须找到这个节点B的前一个节点A，使A.next == A.next.next，
        这样使A指向B的下一个节点C，从而隔过节点B，删除掉节点B。
        那么，我们现在的目标就是找要删除的节点的前一个节点，因为是删除的倒数第n个结点，
        我们可以计算链表的长度，然后通过这个和n，来计算出要删除的节点在第几个，从而解答。
        */

        //使用哨兵节点，可以记录所求链表的头节点位置
        ListNode A = new ListNode(0,head);
        ListNode cur = A;
        //得到链表长度
        int length = getlength(head);
        //根据链表长度，然后通过这个循环，得到索要删除的节点B的前一个节点A
        for(int i = 0; i<length-n; i++){
            cur = cur.next;
        }
        //隔过节点B，使节点A和节点C链接
        cur.next = cur.next.next;
        //返回头节点
        return A.next;
    }
    //这个函数，传进来头节点，然后可以计算链表长度
    public int getlength(ListNode head){
        int length = 0;
        while(head!=null){
            length++;
            head = head.next;
        }
        return length;
    }
}

class Solution {
    /*
    题目：19.删除链表的倒数第N个结点        
    给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        思路：双指针
        这个和上面思路类似，只是所求的要删除的节点B的前一个节点A的方法不同。

        首先还是，要删除一个节点B，那么必须找到这个节点B的前一个节点A，使A.next == A.next.next，
        这样使A指向B的下一个节点C，从而隔过节点B，删除掉节点B。

        他先让aur指针走n个节点，然后aur指针和cur指针一起再走，那样当aur为null时，cur就刚好在节点A处。
        */

        //使用哨兵节点，可以记录所求链表的头节点位置
        ListNode A = new ListNode(0,head);
        ListNode aur = head;
        ListNode cur = A;
        //让aur指针先走n个节点，
        for(int i = 0; i<n; i++){
            aur = aur.next;
        }
        //这样结束的时候，aur指针和cur指针之间就差n个节点，当aur为null时，cur就在要删除的节点的前面一个节点
        while(aur != null){
            aur = aur.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return A.next;
    }
}