public class Solution {
    /*
    121.买卖股票的最佳时机      
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    */
    public int maxProfit(int[] prices) {
        /*
        设定两个变量，cost记录从左到右的最小价格，profit记录每天的价格和cost这个最小价格的差价，遍历后留下的最大的profit就是最佳时机
        */
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);//记录最小买入价格
            profit = Math.max(profit, price - cost);//记录买入和卖出的差价的最大值
        }
        return profit;
    }
}