package hard.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k ; j++) {
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][1] + prices[i],dp[i-1][j][0]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0] - prices[i],dp[i-1][j][1]);
            }
        }
        return dp[n-1][k][0];
    }
}
