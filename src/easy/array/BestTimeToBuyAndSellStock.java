package easy.array;

/**

 * @create: 2018/9/26 9:49
 **/
public class BestTimeToBuyAndSellStock {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * 大概思路就是取一天的值与前一天的值进行比较,加上以前的和,如和小于0,则重新开始计算
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int sum = 0;
        int temp = 0;
        for (int i = 1; i < prices.length ; i++) {
            sum = prices[i] - prices[i-1] + sum;
            if(sum<0){
                sum = 0;
            }
            temp = Math.max(temp,sum);
        }
        return temp;
    }

    public int maxProfit2(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        // 天数,0-未持有,1-持有
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }

}
