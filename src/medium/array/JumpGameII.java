package medium.array;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 * @date 2021/6/4
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,nums[i]+i);
            if(i == end){
                end = max;
                step++;
            }
        }
        return step;
    }
}
