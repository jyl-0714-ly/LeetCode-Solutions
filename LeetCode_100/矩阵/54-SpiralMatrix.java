class Solution {
    /*
    题目：54.旋转矩阵  
    给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    */
    public List<Integer> spiralOrder(int[][] matrix) {
    /*
    思路：顺时针螺旋顺序，分析步骤是，从左到右->从上到下->从右到左->从下到上->从左到右...这样一直循环下去，
    变循环边把缩小边界(相当于切割掉循环过的方块)。
    首先找出矩阵的左(l)、右(r)、上(t)、下(b)边界，可以发现，绕着矩阵方块循环，每次matrix[][]的两个"[]"中，
    总有一个和边界(l、r、t、b)相等，这样就可以很好的找到规律，每次完成一次“从...到...”时l、r、t、b中，
    会缩小，当l>r或者t>b的时候，循环结束。
    */
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        //分别计算边界的大小
        int l = 0, r = n-1, t = 0, b = m-1;

        //设置循环，顺时针螺旋顺序返回矩阵元素
        while(true){
            //从左到右，t不变，都是最上面的一行，列不断向右，每次添加元素到集合
            for(int i = l; i<=r; i++)    list.add(matrix[t][i]);
            //++t，先加后对比，这样不仅可以缩小遍历过的行，还可以比较是否遍历完全
            if(++t>b) break;

            //从上到下，r不变，都是最右边的一列，行不断向下，每次添加元素到集合
            for(int i = t; i<=b; i++)    list.add(matrix[i][r]);
            //--r，先减后对比，这样不仅可以缩小遍历过的列，还可以比较是否遍历完全
            if(--r<l) break;

            //从右向左，b不变，都是最下边的一行，列不断向左，每次添加元素到集合
            for(int i = r; i>=l; i--)    list.add(matrix[b][i]);
            //--b，先减后对比，这样不仅可以缩小遍历过的行，还可以比较是否遍历完全
            if(--b<t) break;

            //从下到上，l不变，都是最左边的一列，行不断向上，每次添加元素到集合
            for(int i = b; i>=t; i--)    list.add(matrix[i][l]);
            //++l，先加后对比，这样不仅可以缩小遍历过的列，还可以比较是否遍历完全
            if(++l>r) break;
        }

        //最后返回集合
        return list;
    }
}