class Solution {
    /*
    题目：48.旋转图像   
    给定一个n×n的二维矩阵matrix表示一个图像。请你将图像顺时针旋转90度。

    注：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
    */
    public void rotate(int[][] matrix) {
    /*
    思路：观察顺时针旋转90°后，可以观察到每个元素都是按照一定规律在进行交换，每4个元素，前后交替，交换位置，
    现在需要找到他们的规律，因为直接交换会被覆盖，所以设一个中间变量temp，则：
    我们可以让temp = matrix[i][j]，然后使matri[i][j]的上一个元素，覆盖掉matri[i][j]，这样循环下去，
    最后让temp的值，赋给matri[i][j]要给的下一个元素。
    容易得到，两个循环相邻元素之间关系matrix[i][j] = matrix[n-j-1][i]，i->n-j-1，j->i。
    则matrix[n-j-1][i]的下一个可以这样得到，令i=n-j-1,j=i。然后再次带入i->n-j-1，j->i。
    可以得到这四个循环往复的规律。
    关于循环次数，可以这样来算：一个int n = matrix.length;的矩阵，需要枚举到n²次，
    则是i的最大次数 * j的最大次数 * 4 = n²； 
    当n为偶数时：得n²/4 = (n/2) * (n/2)，可得i，j的循环次数；
    当n为奇数时：因为最中间元素不动，得(n²-1)/4 = ((n-1)/2) * ((n+1)/2)，可得i，j的循环次数。
    */
        int n = matrix.length;
        for(int i = 0; i<n/2; i++){
            for(int j = 0; j<(n+1)/2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}