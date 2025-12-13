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
    题目：105.从前序与中序遍历序列构造二叉树    
    给定两个整数数组preorder和inorder，其中preorder是二叉树的先序遍历，
    inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
    */
    //设置全局变量，能够避免方法递归时影响这两个值的变化的同时，还能用这两个变量
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        思路：分治、递归、哈希表
        根据前序遍历：根-左-右，中序遍历：左-根-右，的特点，得知前序数组的第一个值后，就是根节点root，
        这个root在中序数组中，其左边为左子树元素，右边为右子树元素，根据中序遍历特点：左-根-右，
        再结合前序数组的元素顺序，即可计算出root的左右子树，然后根据分治思想，再将中心，即root这个根节点，
        转移到左右子树中，依据数组区间，再次计算字树的左右子树。
        */
        this.preorder = preorder;
        //将中序数组添加到哈希表中
        for(int i = 0; i<inorder.length; i++){
            dic.put(inorder[i], i);
        }
        return recur(0,0,inorder.length-1);
    }
    public TreeNode recur(int root, int left, int right){
        //递归结束条件
        if(left > right){
            return null;
        }
        //创建节点
        TreeNode node = new TreeNode(preorder[root]);
        //计算根节点在中序遍历中的位置
        int i = dic.get(preorder[root]);
        //构建左子树，并通过递归链接
        node.left = recur(root + 1, left, i - 1);
        //计算出右子树在前序数组的位置，构建右子树，并通过递归链接
        node.right = recur(root + i - left + 1, i + 1, right);
        //每次返回构建的节点，能够使节点前后链接起来
        return node;
    }
}