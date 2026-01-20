class Solution {
    /*
    题目：56.合并区间       
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
    请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    */
    public int[][] merge(int[][] intervals) {
        /*
        思路：先把区间按左端点的从小到大顺序排序，然后对比相临两个区间右端点的大小，看是否合并，相交的话合并，反之不合并，直接添加。
        */
        Arrays.sort(intervals, (p,q) -> p[0] - q[0]);//按照数组的左端点从小到大排序
        List<int[]> ans = new ArrayList<>();//因为合并区间数量不确定，所以用集合来灵活匹配
        for(int[] p : intervals){//遍历每个区间
            int m = ans.size();//集合中，区间的个数
            //当含有区间时，当前区间和上一个区间对比是否合并，如果当前区间右端点大于等于上一个区间的右端点，则合并
            if(m > 0 && p[0] <= ans.get(m-1)[1]){
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]);//对比一下区间右端点，然后确定用哪个
            }else{
                ans.add(p);//当集合中没有区间或不能合并时，添加到区间内
            }
        }
        return ans.toArray(new int[ans.size()][]);//根据区间数量，把集合转换为数组
    }
}