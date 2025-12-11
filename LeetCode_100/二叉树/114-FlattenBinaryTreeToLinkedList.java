/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    题目：114.二叉树展开为链表      
    给你二叉树的根结点root，请你将它展开为一个单链表：
        开后的单链表应该同样使用TreeNode，其中right子指针指向链表中下一个结点，而左子指针始终为null。
        展开后的单链表应该与二叉树先序遍历顺序相同。
    */
    public void flatten(TreeNode root) {
        /*
        思路：前序遍历
        因为前序遍历的性质，节点->左子树->右子树，以这样的顺序递增，那么我们就可以将右子树插到左子树的右字树位置，
        会发现，前序遍历结果依然不变。插完后，节点右子树处为null，就可以把节点的左子树插到右子树了，插完后，
        前序遍历结果依旧不变，所以就可以这样循环下去，直到变为一条单链表。
        */
        while(root != null){
            //当左子树为null时，说明这个节点已经处理完，换下一个节点处理
            if(root.left == null){
                root = root.right;
            }else{
                //创建一个节点来存储左子树节点，以便后面交换
                TreeNode node = root.left;
                //找到左子树的最右边节点
                while(node.right != null){
                    node = node.right;
                }
                //将根节点的右子树放到上面循环找到的最右节点
                node.right = root.right;
                //然后再将左子树放大右子树位置
                root.right = root.left;
                //左子树置null，是为了避免两个指针指向一个地址
                root.left = null;
                //换下一个节点
                root = root.right;
            }
        }
    }
}

class Solution {
    //中间节点
    private TreeNode node;
    public void flatten(TreeNode root) {
        /*
        思路：头插法、递归、逆前序遍历
        本题要求的顺序是前序遍历顺序，即1->2->3->4->5->6，而逆前序遍历顺序则为：6->5->4->3->2->1
        因为逆前序遍历递归后，先处理最后的一个节点，是倒着处理的，所以可以让这最后一个节点的右子树指向一个中间节点，
        然后以此类推，让倒数第二个递归处理的节点，指向倒数第一，即6->node，node==6,5->6,node=5,4->5...
        这样递归完全后，可以得到1->2->3->4->5->6。
        */
        //递归结束条件
        if(root == null){
            return;
        }
        //逆前序遍历，右-左-根
        flatten(root.right);
        flatten(root.left);
        //为了满足题目要求，左子树为null
        root.left = null;
        //利用中间节点node进行两个节点的指向变换
        root.right = node;
        node = root;
    }
}