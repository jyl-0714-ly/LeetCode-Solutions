class Solution {
    /*
    题目：416.分割等和子集      
    给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    */
    public boolean canPartition(int[] nums) {
        /*
        思路：动态规划，背包问题
        先计算数组和s，因为数组元素为正整数，当s为奇数时，直接返回false；
        当s为偶数时，有可能满足条件，那么为了满足条件，就需要nums数组中的元素组成一个和为s /= 2。
        此时就相当于，这个背包容量为s /= 2，元素能不能刚好装满。

        设f[j]表示是否装满，则f[j] = f[j] || f[j-x]，其中x是当前元素。
        这个式子表示：如果加上当前元素是否能够装满 || 如果不要当前元素是否能够装满。一层层递推，当j = s时，看是否刚好装满。
        当f[s] = true表示装满，则返回true。
        */
        int s = 0;
        for(int x : nums){
            s += x;
        }
        if(s % 2 != 0){
            return false;
        }
        s /= 2;//s减半
        boolean[] f = new boolean[s + 1];
        f[0] = true;//当包的容量为0时，什么都不做都是满的
        int s2 = 0;
        for(int x : nums){
            s2 = Math.min(s2 + x, s);//往包里添加东西，但不能超过s
            for(int j = s2; j >= x; j--){
                f[j] = f[j] || f[j - x];//如果加上当前元素是否能够装满 || 如果不要当前元素是否能够装满
            }
            if(f[s]){//检查是否刚好填满
                return true;
            }
        }
        return false;
    }
}