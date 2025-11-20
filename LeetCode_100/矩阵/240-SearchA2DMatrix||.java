class Solution {
    /*
    题目：240.搜索二维矩阵||    240-SearchA2DMatrix||.java
    编写一个高效的算法来搜索mxn矩阵matrix中的一个目标值target。
    该矩阵具有以下特性：
    每行的元素从左到右升序排列。
    每列的元素从上到下升序排列。
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        思路：经观察，因为行/列都是按升序来的，要想得知target是否存在，则要从四个角选其一开始对比，方可不遗漏。
        如果从左上角matrix[0][0]开始对比：因为matrix[0][0]是矩阵最小的数，
                                      若target>matrix[0][0]，则不知是在其右还是下，这样效率很低。
        同理，因为右下角是最大的数，也不行。

        则以右上角为例对比：已知len = matrix[0].length - 1，
        如果target>matrix[len][0] -> 说明matrix[len][0]的左边全部舍去，向下走，为target>matrix[len][1]；
        如果target<matrix[len][0] -> 说明matrix[len][0]的下边全部舍去，向左走，为target>matrix[len-1][0]。
        如此一来，则对比一个数，则可以窥探出有一行不可用，效率大大提高。
        同理，用左下角对比也可，与右上角思路一致。
        */
        int len = matrix[0].length - 1;
        int i = 0;
        while(len>=0 && i<matrix.length){//当全部都舍去完后，仍然没找到==target，这返回false
            //具体的对我写的那两段话的实现
            if(target > matrix[i][len]) i++;
            else if(target<matrix[i][len]) len--;
            else return true;
        }
        return false;
    }
}