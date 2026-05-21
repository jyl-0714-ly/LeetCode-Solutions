/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        for(Node n = head; n != null; n = n.next.next){
            n.next = new Node(n.val, n.next);
        }

        for(Node n = head; n != null; n = n.next.next){
            if(n.random != null){
            n.next.random = n.random.next;
            }
        }

        Node bre = new Node(0);
        Node t = bre;
        for(Node n = head; n != null; n = n.next, t = t.next){
            Node c = n.next;
            t.next = c;
            n.next = c.next;
        }
        return bre.next;
    }
}