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
    题目：230.二叉搜索树中第K小的元素       
    给定一个二叉搜索树的根节点root，和一个整数k，请你设计一个算法查找其中第k小的元素（从1开始计数）。
    */
    public int kthSmallest(TreeNode root, int k) {
        /*
        思路：迭代、深度优先搜索、栈
        根据二叉搜索树的性质可得，如果我们运用中序遍历的话，得到的节点值是从小到大排列的，
        所以我们可以将中序遍历的值放到栈中，然后出栈一个元素，则k--，当k==0时，此时刚出栈的元素就是第k小元素。
        */
        Deque<TreeNode> d = new ArrayDeque<>();
        while(root != null || !d.isEmpty()){
            while(root != null){
                //一路向左，把所有左子节点压入栈（相当于递归走到最左边的叶子节点）
                d.push(root);
                root = root.left;
            }
            //弹出最小元素，并把这个元素赋值给root
            root = d.pop();
            k--;
            //当k等于0时，说明已经弹出了所求值
            if(k == 0){
                break;
            }
            //往栈里加入右子树的值
            root = root.right;
        }
        return root.val;
    }
}

class Solution {
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        /*
        思路：递归、中序遍历
        递归时，每层都会--k，当k==0时，就返回当前节点值，与迭代类似，不过这个可以提前返回，更快。
        */
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1; //题目保证节点值非负，用-1表示没有找到
        }
        int leftRes = dfs(node.left);
        if (leftRes != -1) { //答案在左子树中
            return leftRes;
        }
        if (--k == 0) { //答案就是当前节点
            return node.val;
        }
        return dfs(node.right); //右子树会返回答案或者-1
    }
}
