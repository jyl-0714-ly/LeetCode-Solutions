class Solution {
    /*
    题目：118.杨辉三角      
    给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

    在「杨辉三角」中，每个数是它左上方和右上方的数的和。
    */
    public List<List<Integer>> generate(int numRows) {
        /*
        先把只有一行的情况解决掉后，因为每行的第一个和最后一个元素都是1，所以嵌套的额for用来处理中间元素，在这个嵌套元素前后都add(1),
        然后根据杨辉三角特性，每个数是它左上方和右上方的数的和，先找到当前要求的数的位置，然后其行-1，列-1的数，加上行-1，列不变的数
        就是要求的数之和。
        */
        List<List<Integer>> list1 = new ArrayList<>();
        //过滤掉只有一行的情况
        if(numRows == 1){
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list1.add(list2);
            return list1;
        }
        for(int i = 0; i<numRows; i++){
            List<Integer> list2 = new ArrayList<>();//创建每行
            list2.add(1);//添加每行的第一个1
            for(int j = 1; j<i; j++){
                list2.add(list1.get(i-1).get(j-1) + list1.get(i-1).get(j));//把要求的数的左上方和右上方的数相加
            }
            if(i != 0)//过滤掉第一行，因为第一行只有一个1
            list2.add(1);//添加每行的最后一个1
            list1.add(list2);
        }
        return list1;
    }
}