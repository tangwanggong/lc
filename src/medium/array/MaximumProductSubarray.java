package medium.array;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0],curMax = nums[0],curMin=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(nums[i],Math.max(curMax*nums[i],curMin*nums[i]));
            curMin = Math.min(nums[i],Math.min(temp*nums[i],curMin*nums[i]));
            max = Math.max(curMax,max);
        }
        return max;
    }
}
