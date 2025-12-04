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
    题目：101.对称二叉树
    给你一个二叉树的根节点root，检查它是否轴对称。
    */
    public boolean isSymmetric(TreeNode root) {
        /*
        思路：递归
        看到二叉树，第一时间想到递归，当需要判断这个二叉树是否轴对称，可以发现，
        轴对称：根节点的左子树的值，以及左子树的左子树或右子树的值 == 根节点的右子树的右子树或左子树的值
        运用递归，分别传入左右子树，然后一一对比，即可判断。
        */
        return aaa(root.left, root.right); //判断树的左右子树是否对称
    }
    public boolean aaa(TreeNode p, TreeNode q){
        if(p == null && q == null){ //如果两个子树都为空，则对称
            return true;
        }
        if(p == null || q == null){ //如果只有一个子树为空，则不对称
            return false;
        }
        return p.val == q.val && aaa(p.left, q.right) && aaa(p.right, q.left); //递归判断左右子树是否对称
    }
}
