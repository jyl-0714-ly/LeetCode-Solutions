class Solution {   
    /*
    题目：73.矩阵置零
    给定一个mxn的矩阵，如果一个元素为0，则将其所在行和列的所有元素都设为0。请使用原地算法。
    */
    public void setZeroes(int[][] matrix) {
    /*
    思路：使用额外数组
    先分别建立两个数组布尔类型m，n，分别代表矩阵的行和列，再两次遍历矩阵。
    第一次遍历：
    遍历矩阵，当遍历到哪个数为0时，也就意味着，这个数的行和列上的数全都置零，故使这个数所在的行m[i]=true，列n[j]=true。
    第二次遍历：
    m，n分别代表行和列，那么在第一次遍历，有元素被赋值为true，意味着这一行或者一列都置零，所以第二次遍历，就可以用if条件置零。
    */
        //分别求矩阵的行数和列数
        int x = matrix.length;
        int y = matrix[0].length;
        //创建布尔存储第一轮遍历的赋值
        boolean[] m = new boolean[x];
        boolean[] n = new boolean[y];

        //第一轮遍历，将矩阵中某一个为0的数的行和列置为true，为下一轮赋0提供条件
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(matrix[i][j] == 0){
                    m[i] = true;
                    n[j] = true;
                }
            }
        }

        //用if条件语句，当哪一行或哪一列为true时，这个行和列的所有元素都置零
        for(int i = 0; i<x; i++){
            for(int j = 0; j<y; j++){
                if(m[i] || n[j]){
                   matrix[i][j] = 0;
                }
            }
        }
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
    /*
    思路：优化上面的空间复杂度为1
    为了减少空间的消耗，不妨可以取消掉数组，而是用单一变量来标记哪一行/列全为零，
    但是又有一个问题，就是如果直接在matrix的第一行/列中标记0，来代表这一行/列置零，
    就不能确定第一行/列原有的元素为0的可能性。
    所以我们可以进行改进：
    用两个布尔的中间变量m，n，分别遍历第一行和第一列，当这其中存在0时，赋值为true，这样就可以在最后置零了。
    因为是先进行的m，n赋值是否为true，那么就可以在后面从第二行和第二列开始遍历，当其中为某一个元素为0时，
    可以标记这个为0的元素的所在行和列的第一行和第一列元素为0，然后再次遍历，置零。
    最后再利用m，n是否为true，判断第一行和第一列是否置零
    */
        //计算矩阵的行和列的长度
        int x = matrix.length;
        int y = matrix[0].length;
        //布尔变量，用来记录第一行和第一列是否存在为0的元素
        boolean m = false;
        boolean n = false;

        //先记录第一行是否存在为0的元素
        for(int i = 0; i<x; i++){
            if(matrix[i][0] == 0){
                m = true;
            }
        }
        //先记录第一列是否存在为0的元素
        for(int i = 0; i<y; i++){
            if(matrix[0][i] == 0){
                n = true;
            }
        }
        //从第二行和第二列开始遍历矩阵，如果元素为0，就标记这个元素所在的第一行和第一列为0
        for(int i = 1; i<x; i++){
            for(int j = 1; j<y; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //在第一次遍历，标记完0后，根据行和列标记的元素是否为0，从而为这标记的行和列的所有元素置零
        for(int i = 1; i<x; i++){
            for(int j = 1; j<y; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                   matrix[i][j] = 0;
                }
            }
        }
        //因为已经借用过第一行做标记了，现在可以利用最开始第一行是否存在0，来判断是否需要为第一行置零
        if(m){
            for(int i = 0; i<x; i++){
                matrix[i][0] = 0;
            }
        }
        //因为已经借用过第一列做标记了，现在可以利用最开始第一列是否存在0，来判断是否需要为第一列置零
        if(n){
            for(int i = 0; i<y; i++){
                matrix[0][i] = 0;
            }
        }
    }
}