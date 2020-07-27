package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @date 2020/5/25
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> lists = new ArrayList<>();
        if(intervals.length==0){
            return lists.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (e1,e2)->{
            return e1[0]-e2[0];
        });
        for (int i = 0; i < intervals.length;i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i<intervals.length-1 && right>=intervals[i+1][0]){
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            lists.add(new int[]{left,right});
        }
        return lists.toArray(new int[0][]);
    }

}
