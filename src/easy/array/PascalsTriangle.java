package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows<1){
            return result;
        }
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> integers = new ArrayList<>();
            integers.add(1);
            List<Integer> last = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                integers.add(last.get(j)+last.get(j-1));
            }
            integers.add(1);
            result.add(integers);
        }
        return result;
    }
}
