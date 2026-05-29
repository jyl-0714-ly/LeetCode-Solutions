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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        aaa(root, 0, list);
        return list;
    }
    public void aaa(TreeNode root, int count, List<Integer> list){
        if(root == null){
            return;
        }
        if(count == list.size()){
            list.add(root.val);
        }
        aaa(root.right, count + 1, list);
        aaa(root.left, count + 1, list);
    }
}