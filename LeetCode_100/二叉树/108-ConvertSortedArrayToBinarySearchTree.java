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
    题目：108.将有序数组转换为二叉搜索树        
    给你一个整数数组nums，其中元素已经按升序排列，请你将其转换为一棵平衡二叉搜索树。
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        /*
        思路：递归
        因为这个数组已经被按照升序排列过，而且还要是平衡二叉搜索树，根据其特点，需要以这个数组的中间数为根节点，
        然后其左边的一段数组的中间点的就作为左子树，右边同理，然后按照这个思路，多层递归，就可以得到结果。
        */
        //求出数组的长短，可以计算大小位于中间的值
        int len = nums.length;
        return min(nums, 0, len-1);
    }
    public TreeNode min(int[] nums, int left, int right){
        //递归结束条件
        if(left>right){
            return null;
        }
        //求中间值作为节点
        int mid = (left + right)/2;
        //将中间值赋值给节点
        TreeNode root = new TreeNode(nums[mid]);
        //左子树节点
        root.left = min(nums, left, mid - 1);
        //右子树节点
        root.right = min(nums, mid + 1, right);
        //返回根节点
        return root;
    }
}