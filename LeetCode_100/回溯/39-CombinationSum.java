class Solution {
    /*
    思路：39.组合总和   
    给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使
    数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

    对于给定的输入，保证和为 target 的不同组合数少于 150 个。
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
        思路：通过DFS回溯，从左到右依次尝试每个数字（允许重复使用），
        用“当前剩余目标值”控制递归边界，并通过“起始索引 i”避免重复组合。
        */
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, target, candidates, ans, path);
        return ans;
    }

    private void dfs(int i, int left, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
        if (left == 0) {
            //找到一个合法组合
            ans.add(new ArrayList<>(path));
            return;
        }

        //枚举选哪个
        for (int j = i; j < candidates.length && candidates[j] <= left; j++) {
            path.add(candidates[j]);
            dfs(j, left - candidates[j], candidates, ans, path);
            path.remove(path.size() - 1);//恢复现场
        }
    }
}