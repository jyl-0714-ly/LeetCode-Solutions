class Solution {
    /*
    题目：46.全排列     
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    */
    public List<List<Integer>> permute(int[] nums) {
        /*
        思路：通过回溯法，按位置依次选择未使用的数字填入排列，利用布尔数组记录使用状态，递归完成后回溯释放选择，
        从而枚举所有可能的全排列
        */
        int n = nums.length;
        List<Integer> path = Arrays.asList(new Integer[n]);
        boolean[] onPath = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, ans, path, onPath);
        return ans;
    }
    //枚举path[i]填nums的哪个数
    private void dfs(int i, int[] nums, List<List<Integer>> ans, 
    List<Integer> path, boolean[] onPath){
        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = 0; j<nums.length; j++){
            if (!onPath[j]) {
                path.set(i, nums[j]);//从没有选的数字中选一个
                onPath[j] = true;//已选上
                dfs(i + 1, nums, ans, path, onPath);
                onPath[j] = false;//恢复现场
                //注意path无需恢复现场，因为排列长度固定，直接覆盖就行
            }
        }
    }
}