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
    题目：226.翻转二叉树    
    给你一棵二叉树的根节点root，翻转这棵二叉树，并返回其根节点。
    */
    public TreeNode invertTree(TreeNode root) {
        /*
        思路：看到二叉树，就想到递归
        分别从根节点开始，交换每一个节点的左右子树，递归进行，即可翻转二叉树成功。
        */
        //递归结束条件
        if(root == null){
            return null;
        }
        //交换左右节点
        TreeNode t = root.right;
        root.right = root.left;
        root.left = t;
        //递归交换左子树的
        invertTree(root.left);
        //递归交换右子树的
        invertTree(root.right);
        return root;
    }
}
