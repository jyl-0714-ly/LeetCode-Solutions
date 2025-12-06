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
    题目：102.二叉树的层序遍历      
    给你二叉树的根节点root，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        思路：广度优先搜索（BFS）
        运用广度优先搜索，可以从上到下，从左到右的一个一个的遍历节点，但是题目要求分层，而广度优先搜索没有分层。
        因此我们可以添加一个通过计算每次往队列中添加完值后的队列长度，然后再用for循环，以此区分每一层。
        而后就可以一层一层的添加了。
        */
        List<List<Integer>> l1 = new ArrayList<>();//创建返回的集合
        if(root == null){//判断头节点是否为空，避免后面往队列里添加root时不会出错
            return l1;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();//创建队列
        queue.add(root);//添加头节点
        //现将头结点的值作为一层添加到集合中
        List<Integer> l3 = new ArrayList<>();
        l3.add(root.val);
        l1.add(l3);
        //队列为空时，表示遍历完树
        while(!queue.isEmpty()){
            //来计算每一层有多少个节点
            int n = queue.size();
            //创建的集合，用来存储每一层的每一个值
            List<Integer> l2 = new ArrayList<>();
            //根据每一层节点个数，然后遍历后往集合里添加
            for(int i = 0; i<n; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    l2.add(node.left.val);
                }
                if(node.right != null){
                    queue.add(node.right);
                    l2.add(node.right.val);
                }
            }
            //避免最后一次循环节点为空时，集合也为空的时候，再将空集合添加到l1中
            if(l2.size() != 0){
                //每层的值，添加到l1中
                l1.add(l2);
            }
        }
        //返回l1
        return l1;
    }
}
