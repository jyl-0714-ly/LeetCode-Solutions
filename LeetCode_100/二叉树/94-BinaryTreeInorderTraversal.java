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
    题目：94.二叉树的中序遍历
    给定一个二叉树的根节点root，返回它的中序遍历。
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
        思路：递归
        中序遍历的顺序是：左 -> 根 -> 右。
        我们可以使用递归来遍历，因为中序遍历顺序为左 -> 根 -> 右，所以先递归左子树，并添加，然后再遍历右子树添加，
        递归结束的条件就是，遇到空节点。
        */
        List<Integer> res = new ArrayList<>();
        aaa(root,res);
        return res;
}
    //递归遍历并添加节点的值
    public void aaa(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        //先添加左子树，符合中序遍历特点
        aaa(root.left, res);
        res.add(root.val);
        aaa(root.right, res);
    }
}
