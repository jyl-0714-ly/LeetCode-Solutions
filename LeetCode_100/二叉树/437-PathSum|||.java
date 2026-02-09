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
    题目：437.路径总和|||   437-PathSum|||
    给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于targetSum的
    路径 的数目。

    路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    */
    private int ans;

    /*
    思路：使用前缀和 + 哈希表 + 回溯的思想高效统计二叉树中路径和等于 targetSum 的路径数量：
    在 DFS 遍历过程中，维护从根到当前节点的路径和 s，并利用哈希表记录该路径上所有前缀和的出现次数；
    对于当前节点，若存在前缀和 s - targetSum，说明从某祖先节点到当前节点的路径和为 targetSum，
    累加其出现次数；递归返回时通过 cnt.merge(s, -1, ...) 撤销当前节点对哈希表的影响（回溯），
    确保哈希表始终只包含当前路径上的前缀和。
    */
    public int pathSum(TreeNode root, int targetSum) {
        // key：从根到 node 的节点值之和
        // value：节点值之和的出现次数
        // 注意在递归过程中，哈希表只保存根到 node 的路径的前缀的节点值之和
        Map<Long, Integer> cnt = new HashMap<>(); 
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }

    // s 表示从根到 node 的父节点的节点值之和（node 的节点值尚未计入）
    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }
        
        s += node.val;
        // 把 node 当作路径的终点，统计有多少个起点
        ans += cnt.getOrDefault(s - targetSum, 0);
        
        cnt.merge(s, 1, Integer::sum); // cnt[s]++
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum); // cnt[s]-- 恢复现场（撤销 cnt[s]++）
    }
}