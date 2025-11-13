class Solution {
    /*
    题目：76.最小覆盖子串
    给你一个字符串s、一个字符串t。返回s中涵盖t所有字符的最小子串。如果s中不存在涵盖t，所有字符的子串，则返回空字符串 "" 。

    注：对于t中重复字符，我们寻找的子字符串中该字符数量必须不少于t中该字符数量。
        如果s中存在这样的子串，我们保证它是唯一的答案。
        s和t由英文字母组成。
    */
    public String minWindow(String s, String t) {
    /*
    思路：滑动窗口+计数差值优化
    核心思路：
    我们使用两个指针left和right表示当前滑动窗口[left, right]。
    通过不断扩张右边界、收缩左边界，找到包含t所有字符的最短子串。

    具体实现：
    设一个arr数组，把字符转换为数字形式存储到arr数组里面。
    先初始化数组，把对标的t字符串，化为字符arr[c]，添加进去，再另择一数con，
    作为统计arr数组有多少个arr[c]，然后再循环添加s字符串的字符到arr中。
    当arr[c]>0表示：窗口缺少该字符；
    当arr[c]=0表示：窗口刚好满足该字符；
    当arr[c]<0表示：窗口多了该字符。

    当我们需要的arr[c]都满足了，即con = 0，那么再循环收缩边界，
    并通过两个中间(ansleft、ansright)变量不断记录最小边界，
    并且每当窗口中移除了我们需要的arr[c]的时候，就需要con++，表示缺少这个arr[c]。
    */
        int[] arr = new int[128];
        int con = 0;//记录还差多少字母
        //初始化序列表
        for(char c : t.toCharArray()){
            if(arr[c] == 0){
                con++;
            }
            arr[c]++;
        }
        //做一些提前准备，将需要的数据算出赋值，后面好利用
        char[] S = s.toCharArray();
        int len = s.length();
        int ansleft = -1;
        int ansright = len;
        int left = 0;

        //开始循环添加s，来对比t，看是否满足
        for(int right = 0; right<len; right++){
            char c = S[right];
            arr[c]--;//这种不是t中字母，但是又在满足要求的子串中间，就--，为-1，表示多了该字符
            if(arr[c] == 0){//s中添加的字母刚好满足，就将con--，为0，表示满足
                con--;
            }
            while(con == 0){//当都满足的时候，就开始试着收缩边界，目的是为了求最小的覆盖子串
                if(right - left < ansright - ansleft){//通过中间变量记录最小值
                    ansleft = left;
                    ansright = right;
                }
                char a = S[left];
                if(arr[a] == 0){
                    con++;
                }
                arr[a]++;//每次当窗口收缩，意味着要丢弃一些字母，那么就需要++，表示这些东西从--到++，没有变，因为一拿一扔=恢复
                left++;//窗口右移
            }
        }
        //当ansleft<0的时候，说明窗口都没变，所以要返回""，反之就通过截取字符串s，返回最小覆盖子串
        return ansleft < 0 ? "" : s.substring(ansleft, ansright + 1);
    }
}