class Solution {
    /*
    题目：15.三数之和
    给你一个整数数组nums，判断是否存在三元组[nums[i],nums[j],nums[k]]满足i!=j、i!=k且j!=k，
    同时还满足nums[i]+nums[j]+nums[k]==0。请你返回所有和为0且不重复的三元组。
        
    注：答案中不可以包含重复的三元组。
    */
    public List<List<Integer>> threeSum(int[] nums) {
    /*
    思路：此题需要先排序+后双指针。
    大致思路：
    需要三个不同的数为索引，此三个索引对应的元素相加为0，那么这三个索引：双指针(left、right)、for循环(i)，刚好满足。
    三个指针找好后，嵌套循环，当i的值确定的时候，那么left和right再进行循环遍历，就能在i恒定的情况下，
    得出所有三个元素的组合找出。那么当i的所有恒定的情况都试过一次后，那么就可以得出最终组合的结果。
    
    细节(去重)：
    ①因为当i的值恒定一次后，那么i所对应的所有剩下的三元素组合，都已被while循环得出过，
    因此当i再一次恒定的值与上一次相等，则会重复，因此跳过。

    ②当i的值恒定时，那么在while循环里就只需要考虑left和right所对应的值之和了，
    那么当left所确定后，right也就只剩一个选择，反之亦然，因此当left/right所对应的值重复相等时，为了去重，就该跳过。
    */
        int len = nums.length;//计算数组长度
        Arrays.sort(nums);//为数组从小到大排序
        List<List<Integer>> ls = new ArrayList<>();//定义集合存储三元素
        if (len < 3) {//当len<3，不符合三元素条件，提前结束，增加效率
            return ls;
        }
        for (int i = 0; i < len; i++) {
            //使left每次都在i前面，right每次都在最后，就是为了当i恒定时，能够得出所有的三元素组合
            int left = i + 1;
            int right = len - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {//对应的第①种去重
                continue;
            } else if (nums[i] > 0) {//因为i所对应元素在最左边，又排过序，故当i对应值大于0，总值必大于0，故跳过，以增加效率
                break;
            }
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {//满足题目条件时，进入if语句，进行添加和去重操作
                    ls.add(Arrays.asList(nums[i], nums[left], nums[right]));//将符合条件的三元素添加到集合中
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])//对应的第②种去重
                        left++;
                    while (left < right && nums[right] == nums[right + 1])//对应的第②种去重
                        right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {//因为排过序，故大于0时，需要right--，来减小总值
                    right--;
                } else {//反之小于0的时候，就需要left++来增大总值
                    left++;
                }
            }
        }
        return ls;
    }
}
