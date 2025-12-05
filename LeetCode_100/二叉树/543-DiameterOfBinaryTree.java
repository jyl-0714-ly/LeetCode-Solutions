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
    题目：543.二叉树的直径 
    给你一棵二叉树的根节点，返回该树的直径。
    注：二叉树的直径是指树中任意两个节点之间最长路径的长度。这条路径可能经过也可能不经过根节点root 。
       两节点之间路径的长度由它们之间边数表示。
    */
    int ans=1;//定义全局变量
    public int diameterOfBinaryTree(TreeNode root) {
        /*
        思路：递归
        以节点为视角，经过这个节点的最大直径=这个节点的左子树的最大长度+这个节点的右子树的最大长度。
        那么我们就可以听过递归，计算每个节点的最大长度，并通过max函数，存储到ans中，每次两两对比，
        最后留下的就是最长的，因为求得是节点个数，所以要-1，最后返回即可。
        */
        aaa(root);
        return ans-1;
    }
    public int aaa(TreeNode root){
        if(root==null){//递归结束条件
            return 0;
        }
        int left = aaa(root.left);//计算该节点左子树的最大长度
        int right = aaa(root.right);//计算该节点右子树的最大长度
        ans=Math.max(ans,left+right+1);//将这个节点的最大长度储存到ans中
        return Math.max(left,right)+1;
    }
}