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
   题目：21.合并两个有序链表   21-MergeTwoSortedLists
   将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
   */
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
   /*
   思路：迭代
   使用哨兵节点，使两个链表值一一对比，较小的那个值，连接到哨兵节点上，当两个链表不一样长时，肯定会有一个剩余，
   此时再把剩余的给连接到我们方才放的哨兵节点链表的后面，最后返回哨兵节点的下一个节点，即新合并链表头。
   */
   
   //定义哨兵节点，这样即可以保留合并链表的头节点，又便于连接对比出来较小的节点
   ListNode p1 = new ListNode(-1);
   ListNode p2 = p1;
   //当两个链表有一个比较完之后，循环结束
   while(list1 != null && list2 != null){
       //节点值较小的节点，连接到哨兵节点后面，这样可以从小到大连接
       if(list1.val < list2.val){
           p2.next = list1;
           list1 = list1.next;
       }else{
           p2.next = list2;
           list2 = list2.next;
       }
        p2 = p2.next;
   }
   //因为还有一个链表可能剩余，所以将剩余的链表连接到合并链表后面
   p2.next = list1 == null ? list2 : list1;
   return p1.next;
   }
}



class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        思路：递归
        每次递归，都留下较小的那个，然后让这个较小的节点，指向后面再次对比之后小的节点，依次递归，
        当一个链表为null时，递归结束。因为是两个链表之间每次递归都会重新指向，没有中间变量，
        所以当一个递归结束之后，最后一个递归比值较小的那个值，会指向最后较长的那个链表。
        因此最后剩哪个链表，返回哪个链表的头节点。
        */

        //递归结束条件，list1和list2有一个为null
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val > list2.val) {//较小的节点指向下一个对比出来较小的节点，如此递归，直到满足递归结束条件
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }
}