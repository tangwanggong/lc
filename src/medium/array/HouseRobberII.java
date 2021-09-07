package medium.array;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * @date 2021/9/7
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[0];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < n-1; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        }
        return Math.max(dp[n-2],dp2[n-1]);
    }
}
