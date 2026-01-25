class Solution {
    /*
    题目：78.子集   
    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    */
    public List<List<Integer>> subsets(int[] nums) {
        /*
        思路：长度为n的数组有2ⁿ个子集，每个子集可以用一个n位的二进制数表示：第j位为1表示选nums[j]，为0表示不选。
        */
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>(1 << n);//预分配空间
        for (int i = 0; i < (1 << n); i++) {//枚举全集U的所有子集i
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {//j在集合i中
                    subset.add(nums[j]);
                }
            }
            ans.add(subset);
        }
        return ans;
    }
}