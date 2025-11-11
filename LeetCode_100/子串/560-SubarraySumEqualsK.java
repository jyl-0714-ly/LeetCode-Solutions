class Solution {
    /*
    题目：560.和为K的子数组
    给你一个整数数组nums和一个整数k，请你统计并返回该数组中和为k的子数组的个数 。

    注：子数组是数组中元素的连续非空序列。
    */
    public int subarraySum(int[] nums, int k) {
    /*
    思路：枚举
    枚举出所有的子数组，并相加，一一与k对照，统计个数，而后返回即可。

    具体：因为第i个元素的前缀和，就是[0...i]的元素之和，
    这样第一层循环s就确定了，从0开始的所有子数组的可能性。
    在第二层循环e，从后往前加，由于内部的条件sum==k就可以再次确定[x...e]这样的子数组的和。
    */
        int count = 0;//用于计数
        for(int s = 0; s<nums.length; s++){//第一层循环，得出[0...s]这个子数组的所以可能性
            int sum = 0;//存储子数组之和，与k对比，每轮归零，以计算每轮的子数组之和
            for(int e = s; e>=0; e--){//能够得出[0...s]这个子数组的子数组包扩本身和
                sum += nums[e];//存储每个子数组的和
                if(sum == k){//通过存储的每个子数组的和，与k对比，得出是否相等，相等则计数
                    count++;
                }
            }
        }
        return count;
    }
}


class Solution {
    /*
    题目：560.和为K的子数组
    给你一个整数数组nums和一个整数k，请你统计并返回该数组中和为k的子数组的个数 。

    注：子数组是数组中元素的连续非空序列。
    */
    public int subarraySum(int[] nums, int k) {
    /*
    思路优化：利用前缀和+哈希表
    因为第i个元素的前缀和，就是[0...i]的数组元素之和，记i的前缀和为sum[i]。
    我们现在需要求子数组和为k的子数组，假设这个子数组是[j...k]，
    那么[j...i] == k，即sum[i] - sum[j] = k，则sum[i] - k = sum[j]。

    因为i>j，所以当第i个元素的前缀和添加到map集合中后，第j个元素的前缀和也一定添加到map集合了，
    那么我们只需要不断地把第i个元素的前缀和添加到map集合中，作为键，
    而后利用sum[i] - k = sum[j]，查询map集合中是否存在sum[j]，如果存在则表示这是一个所求的子数组。
    */
        int count = 0;//计数符合条件的子数组
        int sum = 0;//累计前缀和，并添加到map集合
        Map<Integer, Integer> map = new HashMap<>();//map集合存储前缀和
        map.put(0,1);//规避掉sum[i] - k = 0的情况，这种情况下，刚好一个前缀和等于k，这时可能不存在sum[j]
        for(int i = 0; i<nums.length; i++){//遍历数组
            sum += nums[i];//累计i的前缀和
            //如果sum[i] - k = sum[j],即sum[j]存在，则count就需要拿出sum[j]对应的值，累计起来到自身
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            //不论sum[j]出现与否，都将i的前缀和添加到map集合中，然后添加过，则取出其值并+1，如果未添加过，则赋1
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
    return count;
    }
}