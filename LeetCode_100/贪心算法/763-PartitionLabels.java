class Solution {
    /*
    763.划分字母区间    
    给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
    例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。

    注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
    返回一个表示每个字符串片段的长度的列表。
    */
    public List<Integer> partitionLabels(String s) {
        /*
        思路：题目要求是：
        1.划分区间不能出现重复字母；
        2.划分区间尽可能多。

        因为字符串是由小写字母组成，可以用一个26长度的整数数组来统计一个字母的结尾索引。
        通过遍历更新最大结束索引，来不断划分字母区间。
        */
        char[] c = s.toCharArray();
        int n = c.length;
        int[] last = new int[26];
        for(int i = 0; i<n; i++){//记录一个字母的最大结束索引
            last[c[i] - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0; i<n; i++){
            end = Math.max(end, last[c[i] - 'a']);//更新最大结束索引
            if(end == i){
                ans.add(end - start+1);//计算字母区间的长度并添加到集合中
                start = i + 1;//更新字母长度区间的首位
            }
        }
        return ans;
    }
}