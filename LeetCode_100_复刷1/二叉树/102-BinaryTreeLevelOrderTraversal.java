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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(root.val);
        list.add(l1);
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> l2 = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode herd = queue.poll();
                if(herd.left != null){
                    queue.add(herd.left);
                    l2.add(herd.left.val);
                }
                if(herd.right != null){
                    queue.add(herd.right);
                    l2.add(herd.right.val);
                }
            }
            if(l2.size() != 0){
            list.add(l2);
            }
        }
        return list;
    }
}