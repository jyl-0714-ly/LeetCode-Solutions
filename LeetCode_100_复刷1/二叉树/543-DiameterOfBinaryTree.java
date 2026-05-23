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
    int ans=1;
    public int diameterOfBinaryTree(TreeNode root) {
        
        aaa(root);
        return ans-1;
    }
    public int aaa(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = aaa(root.left);
        int right = aaa(root.right);
        ans=Math.max(ans,left+right+1);
        return Math.max(left,right)+1;
    }
}