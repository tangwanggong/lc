package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        help(0,nums,result,new ArrayList<>());
        return result;
    }

    private void help(int i, int[] nums, List<List<Integer>> result, ArrayList<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            if(j>i && nums[j] == nums[j-1]){
                continue;
            }
            path.add(nums[j]);
            help(j+1,nums,result,path);
            path.remove(path.size()-1);
        }
    }
}
