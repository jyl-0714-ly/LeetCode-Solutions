class Solution {
    /*
    题目：347.前K个高频元素
    给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    */
    public int[] topKFrequent(int[] nums, int k) {
        /*
        思路：采用桶排序（Bucket Sort）思想：首先利用哈希表统计每个元素的出现频率并确定最大频率 maxCnt；
        接着创建大小为 maxCnt + 1 的“桶”数组，将出现次数相同的元素归入对应下标的桶中；最后从高频到低频（倒序）遍历桶，
        依次取出元素填入结果数组，直到凑齐前 k 个高频元素
        */
        // 第一步：统计每个元素的出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum); // cnt[x]++
        }
        int maxCnt = Collections.max(cnt.values());

        // 第二步：把出现次数相同的元素，放到同一个桶中
        List<Integer>[] buckets = new ArrayList[maxCnt + 1];
        Arrays.setAll(buckets, _ -> new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        // 第三步：倒序遍历 buckets，把出现次数前 k 大的元素加入答案
        int[] ans = new int[k];
        int j = 0;
        for (int i = maxCnt; i >= 0 && j < k; i--) {
            // 注意题目保证答案唯一，一定会出现某次循环结束后 j 恰好等于 k 的情况
            for (int x : buckets[i]) {
                ans[j++] = x;
            }
        }
        return ans;
    }
}