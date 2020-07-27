package easy.array;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex+1];
        Arrays.fill(dp,1);
        for (int i = 2; i < dp.length; i++) {
            for (int j = i-1; j > 0; j--) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return Arrays.asList(dp);
    }
}
