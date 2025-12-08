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
    题目：98.验证二叉搜索树     
    给你一个二叉树的根节点root，判断其是否是一个有效的二叉搜索树。
    有效 二叉搜索树定义如下：
                        节点的左子树只包含严格小于当前节点的数。
                        节点的右子树只包含严格大于当前节点的数。
                        所有左子树和右子树自身必须也是二叉搜索树。
    */
    public boolean isValidBST(TreeNode root) {
        /*
        思路：递归
        因为这个二叉搜索树的节点的左子树和右子树分别是严格大于和严格小于当前节点的值，
        那么就可以给这个节点的左子树和右子树的值设置上限和下限。
        首次先定义其值区间为(最小数,最大数)(开区间)
            当递归的是当前节点的左子树时，其左子树的值就在区间(最小数，节点值)内，当不在该区间时，则返回false；
            当递归的是当前节点的右子树时，其右子树的值就在区间(节点值，最大值)内，当不在该区间时，则返回false；
        根据此思路书写递归方法，即可完成此题。。。
        */

        //将数的最大值和最小值传入函数
        return aaa(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean aaa(TreeNode root, long de, long up){
        //递归结束条件
        if(root == null){
            return true;
        }
        //当不符合区间时，返回false
        if(root.val <= de || root.val >= up){
            return false;
        }
        //递归左子树时，最小值不变，最大值更换为当前节点的值
        //递归右子树时，最大值不变，最小值更换为当前节点的值
        return aaa(root.left, de, root.val) && aaa(root.right, root.val, up);
    }
}


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
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        /*
        思路：中序遍历
        根据中序遍历的特点，以及这个二叉搜索树的特点，可以得知，中序遍历的节点值，一直是递增的，
        所以我们可以用一个最小值经历此过程：最小值和当前节点值对比->符合条件->最小值换为当前节点值。
        就这样依据中序遍历递归循环，不符合条件的时候，返回false。
        */
        if(root == null){
            return true;
        }
        //调用左
        if(!isValidBST(root.left)){
            return false;
        }
        //对比中
        if(root.val <= pre){
            return false;
        }
        //替换值
        pre = root.val;
        //调用右
        return isValidBST(root.right);
    }
}