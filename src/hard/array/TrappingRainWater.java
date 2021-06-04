package hard.array;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @date 2021/6/4
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        if(n == 0){
            return result;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        rightMax[n-1] = height[n-1];
        for (int i = n - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        for (int i = 0; i < n; i++) {
            result += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return result;
    }
}
