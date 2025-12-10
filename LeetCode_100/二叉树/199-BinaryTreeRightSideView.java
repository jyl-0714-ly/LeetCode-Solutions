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
    题目：199.二叉树的右视图        
    给定一个二叉树的根节点root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    */
    public List<Integer> rightSideView(TreeNode root) {
        /*
        思路：层序遍历
        和先前写过的二叉树的层序遍历有联系，只需要将层序遍历后的每一层的最后一个元素值取出即可，就是我们看到的节点。
        */
        Queue<TreeNode> queue = new ArrayDeque<>();//创建队列
        List<Integer> l1 = new ArrayList<>();
        if(root == null){//去除个例
            return l1;
        }
        queue.add(root);//添加头节点
        while(!queue.isEmpty()){//队列不为空时循环
            int n = queue.size();//记录一层队列有几个节点
            for(int i = 0; i < n; i++){
                //一层队列弹出，并添加下一层队列
                TreeNode node = queue.poll();
                if(node.left != null)   queue.add(node.left);
                if(node.right != null)  queue.add(node.right);
                //每一层的最后一个节点值就是我们从右边看到的值
                if(i == n-1)    l1.add(node.val);
            }
        }
        return l1;
    }
}


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        /*
        思路：设一个数记录深度，先递归右子树，当这个深度第一次到达，就添加到集合中，确保添加的都是被看到的。
        再递归左子树确保不遗漏。
        */
        List<Integer> ans = new ArrayList<>();
        dfs(root,0,ans);
        return ans;
    }
    public void dfs(TreeNode root, int count, List<Integer> ans){
        if(root == null){
            return;
        }
        //当第一次到达这个层数的时候，添加看到的数
        if(count == ans.size()){
            ans.add(root.val);
        }
        //先递归右子树
        dfs(root.right,count+1,ans);
        //再递归左子树
        dfs(root.left,count+1,ans);
    }
}