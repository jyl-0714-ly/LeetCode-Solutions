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
    题目：124.二叉树的最大路径和    
    二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中
    至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

    路径和 是路径中各节点值的总和。

    给你一个二叉树的根节点 root ，返回其 最大路径和 。
    */
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        /*
        思路：该算法通过后序遍历（DFS）计算二叉树中的最大路径和：对于每个节点，递归求出其左右子树能向上传递
        的最大单侧链和（若为负则舍弃，返回0），同时以当前节点为根拼接左右链形成完整路径，更新全局最大值；最终返
        回的是从当前节点向下延伸的最大链和（用于父节点构造路径），而全局答案 ans 记录了所有可能路径中的最大值。
        */
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;//没有节点，和为0
        }
        int lVal = dfs(node.left);//左子树最大链和
        int rVal = dfs(node.right);//右子树最大链和
        ans = Math.max(ans, lVal + rVal + node.val);//两条链拼成路径
        return Math.max(Math.max(lVal, rVal) + node.val, 0);//该子树最大链和（注意这里和0取最大值了）
    }
}