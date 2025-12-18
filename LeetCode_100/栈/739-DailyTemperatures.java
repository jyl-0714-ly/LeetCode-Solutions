class Solution {
    /*
    题目：739.每日温度      
    给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第i天，
    下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0来代替。
    */
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        思路：从右向左
        因为求的是当前温度距离下一次升高的天数，所以可以从最后一天开始，以最后一天为擂主，从后往前，
        当前面小于擂主，则升温天数 = 擂主索引 - 当前天数索引。如果当前天数 >= 擂主，则用当前天数温度代替擂主，
        因为擂主的answer也已经解决完毕，所以无需考虑，至此可求出answer。 
        */
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        //i--，从后往前
        for(int i = n - 1; i>=0; i--){
            int t = temperatures[i];//当前天数
            //当栈有元素，则有擂主，当前天数去打擂，即当前天数温度对比栈顶(擂主)元素温度，
            //如果胜了，则将它弹出，直到自己当栈顶元素(擂主)
            while(!dq.isEmpty() && t>=temperatures[dq.peek()]){
                dq.pop();
            }
            //当有擂主(栈不为空)的时候，那么当前天数温度必定小于擂主，则用擂主索引-当前天数索引，则为最近升温天数
            if(!dq.isEmpty()){
                answer[i] = dq.peek()-i;
            }
            dq.push(i);//刚开始没有数，则最后一个元素索引进入栈，作为擂主
        }
        return answer;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        思路：从左往右
        此思路就是，从左往右在往栈中添加每日温度的索引的同时，寻找能够大于先前天数的当前天数，
        如果寻找到了这样的一个当前天数，就能够给积压在栈底的先前天数翻案，给予其answer对应值，
        所以每一个数都要按着顺序对比这个数的前面每天的数，只要比其大，就可算出answer，
        算出后就把这些拥有answer的数弹出，避免影响后面的数给栈底其他数翻案，没有被翻案的会自动置零。
        */
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            int t = temperatures[i];//记录当前天数温度
            while(!dq.isEmpty() && t>temperatures[dq.peek()]){//当后面温度大了，就可以给栈中温度赋answer
                //在后面天数中找到了大一点的值，可以给对应answer赋值后弹出(翻案)
                int j = dq.pop();
                answer[j] = i - j;
            }
            dq.push(i);//先把当前天数索引压入栈(羁押)
        }
        return answer;
    }
}