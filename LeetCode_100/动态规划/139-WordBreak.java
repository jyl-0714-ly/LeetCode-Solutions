class Solution {
    /*
    题目：139.单词拆分      
    给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

    注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        思路：动态规划
        拼接单词的话，如果能够拼接成功，那么这个单词必定从左往右，依次能够拆分为几块。
        设f[n]=true则表示长度为n的字符串能够被拼接，则子问题为f[i]=true。
        则当f[i-j]=true时，如果f[i-j,i]=true ，则f[i]=true。
        以此类推，f[i]=true，推断出f[i,n]=true，则f[n]=true.
        那么我们就需要根据字符串的从左往右查找字典的每个单词了，如果从左往右有一段找不到，则这个字符串就不能被拼接。
        */
        int maxlen = 0;
        for(String word : wordDict){
            maxlen = Math.max(word.length(),maxlen);//先找出字典中最长的单词，利用这个长度找字符串的单词，减少了时间复杂度
        }
        Set<String> words = new HashSet<>(wordDict);//快速查找，减少时间复杂度
        int n = s.length();
        boolean[] f = new boolean[n + 1];//先初始化f[i]
        f[0] = true;//f[0]作为做小的子问题，f[0]必定能组成则为true，作为找首个单词的前提
        for(int i = 1; i<=n; i++){
            for(int j = i-1; j>=Math.max(i-maxlen, 0); j--){//找单词，因为单词最大长度不超过maxlen，故[i,maxlen-i]中必定有
                if(f[j] && words.contains(s.substring(j,i))){
                    //当这个单词前面的部分f[i-j]=true是单词，且f[i-j,i]也是单词，则f[i]也是单词
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}