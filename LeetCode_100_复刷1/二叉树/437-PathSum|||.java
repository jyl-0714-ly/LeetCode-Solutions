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
    private int ans;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>(); 
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }
    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }
        
        s += node.val;
        ans += cnt.getOrDefault(s - targetSum, 0);
        
        cnt.merge(s, 1, Integer::sum);
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum);
    }
}