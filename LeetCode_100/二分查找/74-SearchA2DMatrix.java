class Solution {
    /*
    题目：74.搜索二维矩阵         
    给你一个满足下述两条属性的 m x n 整数矩阵：
        1.每行中的整数从左到右按非严格递增顺序排列。
        2.每行的第一个整数大于前一行的最后一个整数。
    给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。  
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        思路：排除行+列中使用二分法
        因为是从左到右递增，而且每行的第一个数大于前一行的最后一个数。所以用target与每行的最后一个数对比，
        如果大于，排除这行，如果小于，那么target就在该行中，此时在这行里面使用二分法找与target相同的数就行了。
        */
        int m = matrix.length - 1;//行索引
        int n = matrix[0].length - 1;//列索引
        for (int i = 0; i <= m; i++) {
            //target刚好和对比的最后一行相等时
            if(target == matrix[i][n]){
                return true;
            }
            //重置二分边界
            int left = 0;
            int right = n;
            //二分查找
            if (target < matrix[i][n]) {
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (target > matrix[i][mid]) {
                        left = mid + 1;
                    } else if (target < matrix[i][mid]) {
                        right = mid - 1;
                    } else if (target == matrix[i][mid]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        思路：看做一维数组直接一次二分法
        由于矩阵每一行是递增的，且每一行的第一个数大于前一行的最后一个数，故当我们把矩阵每一行拼在一起时，
        可以得到一个递增的数组。而后对这个数组进行二分查找，就可以判断是否存在target。
        */
        int m = matrix.length;
        int n = matrix[0].length;
        int left = -1;
        int right = m*n;
        while(left + 1 < right){
            int mid = (left + right)>>>1;
            int x = matrix[mid/n][mid%n];
            if(x == target){
                return true;
            }
            if(x < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return false;
    }
}