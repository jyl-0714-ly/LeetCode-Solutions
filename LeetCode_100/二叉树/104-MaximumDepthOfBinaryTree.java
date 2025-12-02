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
    题目：104.二叉树的最大深度 
    给定一个二叉树root，返回其最大深度。

    注：二叉树的最大深度是指从根节点到最远叶子节点的最长路径上的节点数。
    */
    public int maxDepth(TreeNode root) {
        /*思路：递归
        递归分别计算根节点的左子树的最大深度和右子树的最大深度，然后再计算哪个大，大的+1就是最大深度。
        */
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
